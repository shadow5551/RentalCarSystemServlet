<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="text" scope="application"/>
<html>
<head>
    <title>CarRentalSystem</title>
   <link rel="stylesheet" type="text/css" href="/assets/css/helloPage/car.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/helloPage/bar.css"/>
</head>
<body>
<ul>
    <li><a href="#home"><fmt:message key="login.button.submit"/></a></li>
    <li><a href="#news">News</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#about">About</a></li>
    <li><form action="/">
        <input type="submit" name="locale" value="en">
    </form></li>
    <li><form action="/">
        <input type="submit" name="locale" value="es">
    </form></li>
    <ri><a href="Register">Join Us</a></ri>
    <ri><a href="Login">Login</a></ri>
</ul>
</div>
</body>
</html>
