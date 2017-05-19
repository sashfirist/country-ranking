<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <title>Form</title>
</head>
<body>
<div class="container">
    <sf:form action="../change/${item.id}" commandName="item" method="post">
        <sf:hidden path="id" value="${item.id}"/>
        <label>Country Name :</label>
        <sf:input path="name" value="${item.name}" class="form-control"/><br/>
        <label>Ranking :</label>
        <sf:input path="countryDetailList[0].information" value="${item.countryDetailList[0].information}" class="form-control"/><br/>
        <label>Value :</label>
        <sf:input path="countryDetailList[0].value" value="${item.countryDetailList[0].value}" class="form-control"/><br/>
        <label>Year :</label>
        <sf:input path="countryDetailList[0].year" value="${item.countryDetailList[0].year}" class="form-control"/><br/>
        <sf:hidden path="countryDetailList[0].id" value="${item.countryDetailList[0].id}" class="form-control"/><br/>
        <input class="btn btn-primary" type="submit" value="Submit"/>
    </sf:form>
</div>
</body>
</html>
