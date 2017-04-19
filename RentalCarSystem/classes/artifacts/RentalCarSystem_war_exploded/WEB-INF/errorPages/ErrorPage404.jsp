<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>

<% response.setStatus(404); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>404 error</title>
    <link rel="stylesheet" type="text/css" href="/jsp/errorpages/ErrorPage404.css">
    <link rel="stylesheet" type="text/css" href="/jsp/errorpages/face.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>
                    404 Not Found</h2>
                <div class="error-details">
                    Sorry, an error has occured, Requested page not found!
                </div>
            </div>
        </div>
    </div>
    <div id="man">
        <div id="eye-l"></div>
        <div id="eye-r"></div>
        <div id="nose"></div>
        <div id="mouth"></div>
    </div>
    <div id="wall"></div>
</div>
</body>
</html>