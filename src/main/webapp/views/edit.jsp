<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.8.2.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(function(){
    	$("#profile").click(function() {
			profile();
		});
		$("#login").click(function() {
			login();
		});
	});
	/**$(document).ready(function() {
		$("#profile").click(function() {
			profile();
		});
		$("#login").click(function() {
			login();
		});
	});
	function profile() {
		var url = 'http://localhost:8080/springmvc/profile/';
		var query = $('#user_name').val() + '/' + $('#password').val();
		url += query;
		alert(url);
		$.get(url, function(data) {
			alert("user_name: " + data.user_name + "\npassword: " + data.password);
		});
	}**/
	function login() {
		/**var mydata = '{"user_name":"' + $('#user_name').val() + '","password":"'
				+ $('#password').val() '"}';**/
		alert(111);
		/**$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : 'http://localhost:8080/springmvc/porfile/login',
			processData : false,
			dataType : 'json',
			data : mydata,
			success : function(data) {
			alert("user_name: " + data.user_name + "\npassword: " + data.password);
			},
			error : function() {
				alert('Err...');
			}
		});**/
	}

</script>
  </head>
  
  <body>
  	<sf:form method="POST" modelAttribute="spitter" >
  			<table cellspacing="0">
  				<tr>
  					<th>UserName:</th>
  					<td><sf:input path="user_name" size="15"/></td>
  				</tr>
  				<tr>
  					<th>Password:</th>
  					<td><sf:password path="password" size="15" showPassword="true"/></td>
  				</tr>
  				<tr>
  					<td><button type="submit"/>submit</td>
  					<td><input type="button" id="profile" value="Profile-GET" onClick="login()"/></td>
  					<td><input type="button" id="login" value="Login-POST"/></td>
  				</tr>
  			</table>
  	</sf:form>
  	
  	<input type="button" id="profile1" value="Profile-GET" onClick="login()"/>
  </body>
</html>
