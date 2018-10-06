bodyParser = require('body-parser').json();
var DOMParser = require('xmldom').DOMParser;
const jsdom = require("jsdom");
const {JSDOM} = jsdom;
const doc =  new JSDOM().window.document;

module.exports = function(app, fs) {
    var users = JSON.parse(fs.readFileSync('data.txt', 'utf-8'));
    var items = JSON.parse(fs.readFileSync('item-pages.json', 'utf-8'));
    /*var file_s = fs.readFileSync('data.txt', 'utf-8').split("\n");
    file_s.forEach(function (e) {
        var obj = new Object();
        obj.name = e.split(" ")[0];
        obj.pass = e.split(" ")[1];
        users.push(obj);
    });*/
    console.log(users);

    app.post('/users', bodyParser, function(req, res) {
        var body = req.body;
        console.log(body);
        if (body.name.indexOf(" ") > 0 || body.name === "" ||
            body.password.indexOf(" ") > 0 || body.password === "") {
            res.send("Все поля должны быть заполнены. Данные не должны содержать пробелов");
            return;
        }
        for (var i = 0; i < users.length; i++) {
            if (users[i].name === body.name) {
                res.send("Пользователь с таким именем уже существует");
                return;
            }
        }
        users.push({
            name: body.name,
            pass: body.password.hashCode(),
            session: body.session
        });
        fs.writeFile('data.txt', JSON.stringify(users),
            function (err) {
                if (err) throw err;
                console.log('Saved!');
                res.send("ok");
        });
    });
    app.post('/signin', bodyParser, function(req, res) {
        var body = req.body;
        console.log(body);
        for (var i = 0; i < users.length; i++) {
            if (users[i].name === body.name && users[i].pass === body.password.hashCode()) {
                res.send(JSON.stringify({
                    status: "ok",
                    session: users[i].session
                }));
                return;
            }
        }
        res.send("Такого пользователя не существует")
    });
    app.post('/session', bodyParser, function(req, res) {
        var body = req.body;
        console.log(body);
        for (var i = 0; i < users.length; i++) {
            if (users[i].session == body.session) {
                var json = JSON.parse(JSON.stringify(users[i]));
                delete json.pass;
                res.send(JSON.stringify(json));
                return;
            }
        };
        res.send("Такого пользователя не существует")
    });
    app.post('/avatar', bodyParser, function(req, res) {
        var body = req.body;
        console.log(body);
        for (var i = 0; i < users.length; i++) {
            if (users[i].session == body.session) {
                console.log("avatar detected")
                users[i].avatar = body.avatar;
                saveUsers();
                res.send("ok");

                return;
            }
        };
    });
    app.get('/avatar', function(req, res) {
        var url = require('url');
        var url_parts = url.parse(req.url, true);
        var query = url_parts.query;
        for (var i = 0; i < users.length; i++) {
            if (users[i].session == query.session) {
                var json = {};
                if (users[i].avatar) {
                    json.status = "ok";
                    json.avatar = users[i].avatar;
                } else json.status = "У пользователя нет аватарки"
                res.send(JSON.stringify(json));
                return;
            }
        };
    });
    function saveUsers() {
        fs.writeFile('data.txt', JSON.stringify(users),
            function (err) {
                if (err) throw err;
                console.log('Saved!');
            });
    }
    String.prototype.hashCode = function(){
        var hash = 0;
        for (var i = 0; i < this.length; i++) {
            var character = this.charCodeAt(i);
            hash = ((hash<<5)-hash)+character;
            hash = hash & hash; // Convert to 32bit integer
        }
        return hash;
    }


    /*Формеровщики страниц*/
    app.get('/film', function(req, res) {
        var url = require('url');
        var url_parts = url.parse(req.url, true);
        var query = url_parts.query;
        for (var i = 0; i < items.length; i++) {
            if (items[i].id == query.id) {
                var item = items[i];
                var doc2 = new JSDOM(fs.readFileSync('public/templates/item.html', 'utf-8'))
                var html = doc2.window.document;
                html.getElementById("item_img").src = item.img;
                for (var j = 0; j < item.names.length; j++) {
                    var li = doc2.window.document.createElement("li");
                    li.className = "breadcrumb-item active";
                    li.textContent = item.names[j];
                    html.getElementById("item_names").append(li);
                }
                html.getElementById("item_type").textContent = item.type;
                html.getElementById("item_time").textContent = item.time;
                for (var genres in item.genres) {
                    var span = doc2.window.document.createElement("span");
                    span.className = "badge badge-primary mr-1";
                    span.textContent = item.genres[genres];
                    html.getElementById("item_genres").append(span);
                }
                for (var country in item.country) {
                    var span = doc2.window.document.createElement("span");
                    span.className = "badge badge-primary mr-1";
                    span.textContent = item.country[country];
                    html.getElementById("item_country").append(span);
                }
                html.getElementById("item_rate").textContent = item.rate;
                html.getElementById("item_rate").style.width = item.rate * 10 + "%";
                html.getElementById("item_studio").src = item.studio;
                html.title = item.names[0];
                res.send(doc2.serialize());
            }
        };
    });
    app.get('/', function (req, res) {
       res.redirect("/html/home.html")
    });
    app.get('/search', function(req, res) {
        var url = require('url');
        var url_parts = url.parse(req.url, true);
        var query = url_parts.query;
        var json = [];
        console.log(query);
        if(query.q === "") {
            res.send("[]");
            return;
        }
        if(query.q == "-all") {
            for (var i = 0; i < items.length; i++) {
                json.push({
                    name: items[i].names[0],
                    url: "/film?id=" + items[i].id
                })

            };
            res.send(JSON.stringify(json));
            return;
        }
        for (var i = 0; i < items.length; i++) {
            if (items[i].names[0].toLowerCase().indexOf(query.q.toLowerCase()) > -1 ||
                items[i].names[1].toLowerCase().indexOf(query.q.toLowerCase()) > -1) {

                json.push({
                    name: items[i].names[0],
                    url: "/film?id=" + items[i].id
                })
            }
        };
        res.send(JSON.stringify(json));
    });
    app.get('/news', function (req, res) {
        res.send(JSON.stringify(items));
    });
};