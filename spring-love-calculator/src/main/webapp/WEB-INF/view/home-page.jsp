<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title> Homepage </title>
<style type = "text/css">
.error{
    color: red;
    position: fixed;
    text-align: left;
    margin-left: 30px;
}
</style>

<script type = "text/javascript">
function validateUserName(){
    var userName = document.getElementById("yn").value;
    if(userName.length < 3){
        alert("Please enter user name between 3-15 chars");
        return false;
    }
    else
        return true;
}
</script>
</head>

<body>
<h1 align = "center"> Love Calculator </h1><hr>
<form:form action = "process-homepage" method = "GET" modelAttribute = "userInfo" >
<div align = "center">
<p>
<label for= "yn" > Your name : </label>
<form:input id = "yn" path = "userName"/>
<form:errors path = "userName" cssClass = "error" />
</p>

<p>
<label for= "cn" > Crush name : </label>
<form:input id = "cn" path = "crushName"/>
<form:errors path = "crushName" cssClass = "error" />
</p>

<p>
<form:checkbox path = "termsAndConditions" id = "check"/>
<label>I am agreeing for fun</label>
<form:errors path = "termsAndConditions" cssClass = "error"/>
</p>

<input type = "submit" value = "calculate"/>

</div>
</form:form>
</body>
</html>