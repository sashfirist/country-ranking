<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Info</title>
</head>
<body>
<h1>Welcome @ Ross Country Stats REST project</h1>
<h3>Adding or Updating data from web pages to database</h3>
<table>
    <tr>
        <th>Information Type</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>Population</td>
        <td><a href="/app/pop">Add/Update</a></td>
    </tr>
    <tr>
        <td>Area</td>
        <td><a href="/app/area">Add/Update</a></td>
    </tr>
    <tr>
        <td>Average Life Duration</td>
        <td><a href="/app/duration">Add/Update</a></td>
    </tr>
    <tr>
        <td>Life Quality Index</td>
        <td><a href="/app/lqindex">Add/Update</a></td>
    </tr>
</table>
<h3>REST services</h3>
<table>
    <tr>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>Get all countries and their details</td>
        <td><a href="/rest">Try</a></td>
    </tr>
</table>
</body>
</html>