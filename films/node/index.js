// для отдачи статики
const express = require('express');
// создаем экземпляр объекта
const app = express();

app.get('/', function (request, response) {
    response.redirect("/html/head.html");
});

app.use(express.static('public'));
app.listen(80);
console.log("Server started at 80");