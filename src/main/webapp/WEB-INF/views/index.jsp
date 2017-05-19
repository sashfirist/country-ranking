<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Country Information</title>
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <c:forEach items="${columns}" var="item">
                <th>${item}</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${area}" var="item">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.countryDetailList[0].information}"/></td>
                <td><c:out value="${item.countryDetailList[0].value}"/></td>
                <td><c:out value="${item.countryDetailList[0].year}"/></td>
                <td><a href="./change/<c:out value="${item.id}" />">Change</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
