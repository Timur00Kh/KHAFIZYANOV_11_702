<%@ page import="models.User" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: newt3
  Date: 11.11.2018
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Optional<User> user = (Optional<User>) request.getAttribute("user");%>
<html>
<head>
    <title>${user.get().getName()}</title>
    <jsp:include page="import.jsp" />
    <script src="http://localhost/js/profile.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="row">
        <div class="col-md-3">
            <img id="img_avatar" class="img-fluid rounded" src="${user.isPresent() && user.get().getAvatarUrl() != null ? user.get().getAvatarUrl() : "/img/default_avatar.png"}">
        </div>
        <div class="col-md-9">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page"><h3>${user.get().getName()}</h3></li>
                </ol>
            </nav>

            <h4>Обновить аватар:</h4>
            <div class="input-group mb-3">
                <input type="text" class="form-control" id="avatar_url" placeholder="URL" aria-label="Recipient's username" aria-describedby="">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" id="upd_avatar" type="button" id="button-addon2">Обновить</button>
                </div>
            </div>

            <h4>Обновить пароль:   <span class="badge badge-secondary"> Soon</span></h4>
            <div class="row">
                <div class="col-md-5">
                </div>
            </div>


        </div>
    </div>
</div>

</body>
</html>
