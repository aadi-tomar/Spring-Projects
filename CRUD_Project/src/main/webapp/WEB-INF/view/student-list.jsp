<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Data</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <!--
    <link rel = "stylesheet" type = "text/css" href = "/CRUD_Project/URLToReachResourcesFolder/css/my-style-sheet.css">
    -->
</head>
<body>
<div class = "container" >
<h1 align = "center" > Student Data </h1>

    <form action = "showAddStudent">
        <input type = "submit" value = "ADDStudent" class="btn btn-success"/>
    </form>
    </br>
    <table border = "1" class="table table-striped">
    <thead>
        <tr>
            <td> ID </td>
            <td> NAME </td>
            <td> MOBILE </td>
            <td> COUNTRY</td>
        </tr>
    </thead>

    <c:forEach var = "student" items="${students}">
      <tr>
        <td> ${student.id} </td>
        <td> ${student.name} </td>
        <td> ${student.mobile} </td>
        <td> ${student.country} </td>
        <td> <a href = "updateStudent?userId=${student.id}"> Update </a> </td>
        <td> <a href = "deleteStudent?userId=${student.id}" onclick = "if(!(confirm('Are you sure you want to delete this student ?'))) return false"> Delete </a> </td>
      </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>