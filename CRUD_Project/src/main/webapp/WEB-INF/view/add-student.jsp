<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div align = "center">
<h2> Add Student </h2>
<form:form action = "save-student" modelAttribute= "studentDTO" method = "POST" >

    <form:hidden path = "id"/>
    <label> Name : </label>
    <form:input path = "name" />
    </br>
    <label> Mobile : </label>
    <form:input path = "mobile" />
    </br
    <label> Country : </label>
    <form:input path = "country" />
    </br>
    <input type = "submit" value = "Submit"/>

</form:form>
</div>
</body
<html