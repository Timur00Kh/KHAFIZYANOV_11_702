<%--
  Created by IntelliJ IDEA.
  User: newt3
  Date: 11.11.2018
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
    <jsp:include page="import.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
<form method="post">
    <input type="text" name="email" placeholder="" />
    <input type="password" name="password" placeholder="" />
    <input type="password" name="password2" placeholder="" />
    <input type="submit" value="Го" />
</form>
</body>
</html>