<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Add new user</title>
</head>
<body>
<form method="post" action='Login'>
    login : <input
        type="text" name="login"
        value="<c:out value="${user.login}" />" /> <br />
    password : <input
        type="text" name="password"
        value="<c:out value="${user.password}" />" /> <br />
    <div><c:out value="${error}" /></div><br />
    <input
        type="submit" value="Submit" />
</form>
</body>
</html>