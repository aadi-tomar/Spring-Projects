<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title> Homepage </title>

<script type = "text/javascript">
function validateUserName(){
    var userName = document.getElementById("yn").value;
    if(userName.length < 1){
        alert("Please enter user name");
        return false;
    }
    else
        return true;
}
</script>
</head>

<body>
<h1 align = "center"> Love Calculator </h1><hr>
<form:form action = "process-homepage" method = "get" modelAttribute = "userInfo" onsubmit = "validateUserName()" >
<div align = "center">
<p>
<label for= "yn" > Your name : </label>
<form:input id = "yn" path = "userName"/>
</p>

<p>
<label for= "cn" > Crush name : </label>
<form:input id = "cn" path = "crushName"/>
</p>

<input type = "submit" value = "calculate"/>

</div>
</form:form>
</body>
</html>