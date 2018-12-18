
function init() {
    document.getElementById('upd_avatar').addEventListener('click', function (e) {
        updateAvatar();
    })
}

function updateAvatar() {
    var url = document.getElementById('avatar_url').value;
    $.ajax({
        type: 'post',
        url: '/updateAvatar',
        data: {
            url: url,
        }
    }).done(function (data) {
        if (data && data === "OK") {
            document.getElementById('avatar_url').value = '';

            document.getElementById('img_avatar').src = url;

        } else {
            SignAlert.alert('Nope');
        }
    })
}

$(document).ready(function(){ init();});

