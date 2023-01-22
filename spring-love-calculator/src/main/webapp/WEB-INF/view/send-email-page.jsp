<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title> Email Page</title>
</head>

<body>
<h1> HI ${userName}</h1>
<h2> Send result to your Email </h2>

<form:form action = "processEmail" method = "GET" modelAttribute = "emailDTO" >

<label> Enter your email</label>
<form:input path = "userEmail"/>
<input type = "submit" value = "send"/>

</form:form>
<hr>
</body>
</html>