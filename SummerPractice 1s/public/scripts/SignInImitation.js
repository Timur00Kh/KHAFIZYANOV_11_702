// возвращает cookie с именем name, если есть, если нет, то undefined
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

var mode = 0;
var AVATAR = "/images/miss_img.png";

function checkAcc() {
    if (getCookie("SuperSite") && getCookie("SuperSite") === "1") {
        var json = JSON.stringify({
            session: getCookie("SuperSiteSession")
        });
        var http = new XMLHttpRequest();
        http.open('POST', "/session");
        http.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        http.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                console.log(http.responseText);
                var res = JSON.parse(http.responseText);
                if (res.name) {
                    document.querySelector("#s-btn").style = "display: none";
                    document.querySelector("#acc").style = "";
                    document.querySelector("#usName").innerHTML = res.name;
                    document.getElementById("avatar").src = res.avatar ? res.avatar : AVATAR;
                }
            }
        }
        http.send(json);

        // document.querySelector("#avatar").src = getAvatar(document.querySelector("#usName").innerHTML);

    } else {
        document.querySelector("#acc").style = "display: none";
        document.querySelector("#s-btn").style = "";
    }
}

function getAvatar() {
    console.log("ssdadsssss")
    if (getCookie("SuperSiteAvatar") == 1) {
        var s = "/avatar?type=get&name="
            + getElbyID("#SUcustomUsername").value;
        var http = new XMLHttpRequest();
        http.open('GET', s);  // составить асинхронный (по умолчанию true) GET запрос страницы
        http.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                if (http.responseText != "Something went wrong") {
                    return http.responseText;
                } else {
                    return "https://3.bp.blogspot.com/-yAi6yxPJK5Y/WAcsoGFq9DI/AAAAAAAAIzU/HoBVIr-l8jcLPgqx1CpNFtLTYkOR2kRxACLcB/s1600/1457633527.png";
                }
                console.log(http);
            }
        }
        http.send();
    }
}

document.querySelector("#exit").onclick = function () {
    document.cookie = "SuperSite=0";
    checkAcc();
};

document.querySelector("#go").onclick = function () {
    if (mode === 0) {
        var json = JSON.stringify({
            name: getElbyID("#SIcustomUsername").value,
            password: getElbyID("#SIpassword").value
        });
        var http = new XMLHttpRequest();
        http.open('POST', "/signin");
        http.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        http.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var res = JSON.parse(http.responseText);
                if (res.status === "ok") {
                    document.querySelector("#close").click();
                    document.cookie = "SuperSite=1";
                    document.cookie = "SuperSiteSession=" + res.session;
                    checkAcc();
                } else {
                    getElbyID("#alertSign").style.display = "";
                    getElbyID("#alertSign").innerText = http.responseText;
                }
                console.log(http);
            }
        }
        http.send(json);
    } else if (mode === 1) {
        if (getElbyID("#SUpassword").value === getElbyID("#SUpasswordCheck").value) {
            console.log("check");
            getElbyID("#alertSign").style.display = "none";
            var newSession = getRandomInt(10000, 99999);
            var json = JSON.stringify({
                name: getElbyID("#SUcustomUsername").value,
                password: getElbyID("#SUpassword").value,
                session: newSession
            });
            var http = new XMLHttpRequest();
            http.open('POST', "/users");  // составить асинхронный (по умолчанию true) GET запрос страницы
            http.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            http.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    if (http.responseText === "ok") {
                        document.querySelector("#close").click();
                        document.cookie = "SuperSite=1";
                        document.cookie = "SuperSiteSession=" + newSession;
                        checkAcc();
                    } else {
                        getElbyID("#alertSign").style.display = "";
                        getElbyID("#alertSign").innerText = http.responseText;
                    }
                    console.log(http);
                }
            }
            http.send(json);
        } else{
            getElbyID("#alertSign").style.display = "";
            getElbyID("#alertSign").innerText = "Пароли не сопадают";
        }
    }

};

function getElbyID(s) {
    return document.querySelector(s);
}

checkAcc();

/*Далее контроллер переключений Sign in / Sign up*/
document.querySelector("#sign_in_control").onclick = function () {
    document.querySelector("#sign_in_control").className = "nav-link active";
    document.querySelector("#sign_up_control").className = "nav-link";
    document.querySelector("#sign_in").style.display = "";
    document.querySelector("#sign_up").style.display = "none";
    mode = 0;
};
document.querySelector("#sign_up_control").onclick = function () {
    mode = 1;
    document.querySelector("#sign_up_control").className = "nav-link active";
    document.querySelector("#sign_in_control").className = "nav-link";
    document.querySelector("#sign_in").style.display = "none";
    document.querySelector("#sign_up").style.display = "";
};

function getRandomInt(min, max){
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

