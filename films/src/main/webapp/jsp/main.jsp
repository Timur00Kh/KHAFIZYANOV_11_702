<%--
  Created by IntelliJ IDEA.
  User: newt3
  Date: 12.11.2018
  Time: 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Films</title>
    <jsp:include page="import.jsp" />
    <script src="http://localhost/js/main.js"></script>

</head>
<body>
<jsp:include page="header.jsp" />

<div class="container my-5">
    <div class="row">
        <div class="col-12">
            <h2>Поиск:</h2>
            <input id="bigSearch" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        </div>
        <div class="mt-4 w-100"></div>
        <div class="col-12 text-center" id="loading">
            <i class="fas fa-spinner fa-2x fa-spin"></i>
        </div>
    </div>
    <div class="row" id="subj_container" style="min-height: 400px">



        <%--<div class="col-sm-6 col-md-3">--%>
            <%--<a class="card" href="#" style="">--%>
                <%--<img class="card-img-top" data-placement="right" data-toggle="popover" data-trigger="hover" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?" src="https://st.kp.yandex.net/images/film_iphone/iphone360_1042556.jpg" alt="Card image cap">--%>
            <%--</a>--%>
        <%--</div>--%>
    </div>
</div>


</body>
</html>
