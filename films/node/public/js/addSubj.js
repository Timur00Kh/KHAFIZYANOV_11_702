var errAlert, alertSuccess;

function initAddSubj() {
    errAlert = document.getElementById("errAlert");
    errAlert.alert = function(msg) {
        errAlert.style.display = "";
        errAlert.querySelector('span').innerText = msg;
    };

    alertSuccess = document.getElementById("alertSuccess");
    alertSuccess.alert = function(msg) {
        errAlert.style.display = "none";
        alertSuccess.style.display = "";
        alertSuccess.querySelector('span').innerHTML = msg;
    };


    $('form').submit(function() {
        $theForm = $(this);

        // send xhr request
        $.ajax({
            type: $theForm.attr('method'),
            url: $theForm.attr('action'),
            data: $theForm.serialize(),
            success: function(data) {
                if (data == "OK") {
                    $theForm.remove();
                    alertSuccess.alert("Фильм добавлен!")
                } else {
                    errAlert.alert(data);
                }
            }
        });

        // prevent submitting again
        return false;
    });


}


$(document).ready(function(){ initAddSubj();});
