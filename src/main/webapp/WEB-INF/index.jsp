<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <!-- For any Bootstrap that uses JS-->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <h1> Querry One</h1>
    <table>
        <thead>
        <tr>
            <th>Country</th>
            <th>Language</th>
            <th>Presentage</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${slovene}">
        <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
                <td>${item[2]} %</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query tow</h1>
    <table>
        <thead>
        <tr>
            <th>Country</th>
            <th>Cites</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cites}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query Three</h1>
    <table>
        <thead>
        <tr>
            <th>Cities</th>
            <th>Popullation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${mescko}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query Four</h1>
    <table>
        <thead>
        <tr>
            <th>Country</th>
            <th>Prestages</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${lang}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query Five</h1>
    <table>
        <thead>
        <tr>
            <th>Country</th>
            <th>Prestages</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${lang}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query Six</h1>
    <table>
        <thead>
        <tr>
            <th>Country</th>
            <th>Surfaces</th>
            <th>Popullation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${surface}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
                <td>${item[2]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query Seven</h1>
    <table>
        <thead>
        <tr>
            <th>Country</th>
            <th>Cities</th>
            <th>District</th>
            <th>Citi Popullation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${messi}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
                <td>${item[2]}</td>
                <td>${item[3]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query eight</h1>
    <table>
        <thead>
        <tr>
            <th>region</th>
            <th>total cites</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${region}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <h1> Query nine</h1>
    <table>
        <thead>
        <tr>
            <th>region</th>
            <th>total cites</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${coun}">
            <tr>
                <td>${item.name}</td>
                <td>${item.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>