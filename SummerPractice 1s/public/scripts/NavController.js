var http = new XMLHttpRequest();
http.open('GET', '/templates/nav.html');  // составить асинхронный (по умолчанию true) GET запрос страницы
http.onreadystatechange = function () {
    console.log("sdcfsdf");
    if (this.readyState == 4 && this.status == 200) {  // отследить момент, когда пришёл полный ответ
        var nav = document.createElement("div");
        nav.innerHTML = this.responseText;
        document.body.prepend(nav);
        var script = document.createElement("script");
        script.src = "/scripts/SignInImitation.js";
        document.head.append(script);
    }
}
http.send();

