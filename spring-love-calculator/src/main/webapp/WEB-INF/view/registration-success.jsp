<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> Registration Details </title>
</head>

<body>
<h1> Your registration is successful </h1>
<h2> The details entered are : </h2>
User :  ${userRegistration.name} <br/>
User Name :  ${userRegistration.userName} <br/>
Password :  ${userRegistration.password} <br/>
Country :  ${userRegistration.countryName} <br/>
Hobbies :
<c:forEach var = "temp" items = "${userRegistration.hobbies}">
${temp}
</c:forEach>
 <br/>
Gender :  ${userRegistration.gender} <br/>
</body>
</html>