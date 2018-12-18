var user, SignAlert, history, t;

function init() {
    user = {
        name: document.getElementById('user_min_name'),
        img: document.getElementById('user_min_img'),
        user_min: document.getElementById('user_min'),
        login_btn: document.getElementById('login_btn'),
        auth: function (user) {
            this.name.innerText = user.name;
            if (user.avatarUrl) this.img.src = user.avatarUrl;

            this.login_btn.style.display = "none";
            this.user_min.style.display = '';
            document.getElementById('close_btn').click()
            // setCookie('auth',)
        },
        exit: function () {
            delete_cookie('auth');

            this.login_btn.style.display = "";
            this.user_min.style.display = 'none';
        }
    };

    console.log( document.getElementById('signup_btn'));

    document.getElementById('signup_btn').addEventListener('click', function (e) {
        signUp()
    });

    document.getElementById('exit_btn').addEventListener('click', function (e) {
        user.exit();
    });

    document.getElementById('signin_btn').addEventListener('click', function (e) {
        signIn()
    });

    SignAlert = document.getElementById('alert');
    SignAlert.alert = function (msg) {
        SignAlert.style.display = '';
        SignAlert.querySelector("span").innerText = msg;
    };

    history = document.getElementById("history");
    history.appendEl = function(msg) {
        var li = document.createElement("li");
        li.className = "list-group-item";
        li.innerText = msg;
        document.getElementById("history").append(li);
    };

    t = 0;
    var hisTimer;
    document.getElementById("history").addEventListener('scroll', function (e) {
        var o = e.target;
        clearTimeout(hisTimer);
        console.log((o.offsetHeight + o.scrollTop) + " " +  o.scrollHeight);
        if(Math.abs(o.offsetHeight + o.scrollTop - o.scrollHeight) < 20) {
            hisTimer = setTimeout(function () {
                loadHistory(t + 10, t);
            }, 500);
        }
    });

    loadHistory(10,0);

}

console.log('sdfsdfsdfsdf');

function loadHistory(limit, offset) {
    $.ajax({
        type: 'post',
        url: '/history',
        data: {
            limit: limit,
            offset: offset
        }
    }).done(function (data) {
        t += 10;
        console.log(data);
        if (data !== null) {
            data.forEach(function (v) {
                history.appendEl(v.actionTitle)
            })
        } else {

        }

    });
}


function setUser(session) {
    $.ajax({
        type: 'post',
        url: '/getMe',
        data: {
            uuid: session
        }
    }).done(function (data) {
        console.log(data);
        if (data !== null) {
            user.auth(data);
        } else {
            SignAlert.alert('something went wrong');
        }
    })
}

function signIn() {
    $.ajax({
        type: 'post',
        url: '/signIn',
        data: {
            email: document.getElementById('signin_name').value,
            password: document.getElementById('signin_pass').value,
        }
    }).done(function (data) {
        if (data && data.status === "OK") {
            setUser(data.uuid);
        } else if (data && data.status === "ERR"){
            SignAlert.alert(data.desc);
        }
    })
}

function signUp() {
    $.ajax({
        type: 'post',
        url: '/signUp',
        data: {
            email: document.getElementById('signin_name').value,
            password: document.getElementById('signup_pass').value,
            password2: document.getElementById('signup_pass2').value,
        }
    }).done(function (data) {
        if (data && data.status === "OK") {
            setUser(data.uuid);
        } else if (data && data.status === "ERR"){
            SignAlert.alert(data.desc);
        }
    })
}


function setCookie(name, value, options) {
    options = options || {};

    var expires = options.expires;

    if (typeof expires == "number" && expires) {
        var d = new Date();
        d.setTime(d.getTime() + expires * 1000);
        expires = options.expires = d;
    }
    if (expires && expires.toUTCString) {
        options.expires = expires.toUTCString();
    }

    value = encodeURIComponent(value);

    var updatedCookie = name + "=" + value;

    for (var propName in options) {
        updatedCookie += "; " + propName;
        var propValue = options[propName];
        if (propValue !== true) {
            updatedCookie += "=" + propValue;
        }
    }

    document.cookie = updatedCookie;
}

function delete_cookie( name ) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

$(document).ready(function(){ init();});