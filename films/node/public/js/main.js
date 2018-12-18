var subj_container, subj_controller;

function initMain() {

    subj_container = document.getElementById('subj_container');
    subj_controller = {
        clear: function () {
            subj_container.innerHTML = '';
        },
        addSubj: function(subj) {
            var div = document.createElement('div');
            div.className = "col-sm-6 col-md-3 mt-2";
            var a = document.createElement('a');
            a.className = "card";
            a.href = '#';
            div.append(a);

            a.innerHTML = '<img class="card-img-top" data-placement="right" data-toggle="popover" data-trigger="hover"'
                + ' id="' + subj.id
                + '" title="' + subj.title
                + '" data-content="' + subj.desc.substr(0,300)
                + '" src="' + subj.posterUrl
                + '">';

            subj_container.append(div);

            /*$('#' + subj.id).popover({
                'delay': {"show": 200, "hide": 1000 }
            });*/

        }

    };

    let lastQuery = "";
    let timer;
    document.getElementById('bigSearch').addEventListener('keyup', function () {
        lastQuery = document.getElementById('bigSearch').value;
        clearTimeout(timer);
        if (lastQuery.length === 0) {
            load();
            return;
        }

        timer = setTimeout(function () {
            console.log(document.getElementById('bigSearch').value);
            findByName(document.getElementById('bigSearch').value);
        }, 500)

    });

    load();


}

function load() {
    $('.popover').remove();
    document.getElementById('loading').style.visibility = "visible ";
    $.ajax({
        type: 'post',
        url: '/getSubj',
        data: {}
    }).done(function (data) {
        subj_controller.clear();
        if (data) {
            data.forEach(function (v) {
                subj_controller.addSubj(v);
            });
            document.getElementById('loading').style.visibility = "hidden";
            $(function () {
                $('[data-toggle="popover"]').popover()
            });
        }
    });
}

function findByName(name) {
    document.getElementById('loading').style.visibility = "visible ";
    $.ajax({
        type: 'post',
        url: '/getSubj',
        data: {name: name}
    }).done(function (data) {
        $('.popover').remove();
        subj_controller.clear();
        if (data) {
            data.forEach(function (v) {
                subj_controller.addSubj(v);
            });
            document.getElementById('loading').style.visibility = "hidden";
            $(function () {
                $('[data-toggle="popover"]').popover()
            });
        }
    });
}

$(document).ready(function(){ initMain();});