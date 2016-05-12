<%@ include file="../common/include_tag.jsp"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SWINEPIG</title>

<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/login/styles.css'/>" />
</head>
<body>


<div class="wrapper">
	<div class="container">
		<h1>Welcome</h1>
		<c:if test="${not empty error}">
             <div class="error"><c:out value="${error}"></c:out></div>
         </c:if>
         <!--  ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message} -->
         <c:if test="${not empty msg}">
             <div class="msg"><c:out value="${msg}"></c:out></div>
     	</c:if>
		<form class="form" name="f" method="post" action="<c:url value='/j_spring_security_check'/>" id="loginform">
			<input type="text" placeholder="Username" name="j_username" id="user_name">
			<input type="password" placeholder="Password" name="j_password" id="user_password" >
			<button type="button" id="login-button">Login</button>
		</form>
	</div>
	<div class="container">
		<h1>Welcome</h1>
        <c:if test="${not empty msg}">
             <div class="msg"><c:out value="${msg}"></c:out></div>
     	</c:if>
		<form class="form"  method="post" action="<c:url value='/user/regeist'/>">
			<input type="text" placeholder="Username" name="userName" />
			<input type="password" placeholder="Password" name="password" />
			<button type="submit" id="login-button">Regeist</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>

<script type="text/javascript" src="<s:url value='/resources/js/jquery-1.8.0.min.js'/>"></script>
<script type="text/javascript">
$(function(){
	  $("#login-button").click(function() {
          $("#loginform").submit();
          $("#login-button").html("Loading....");
          $("#login-button").attr("disabled", "disabled");
      });
});

</script>

</body>
</html>