<%@page import="user.dto.UserCert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User 修改</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/javaweb/css/buttons.css">
	</head>
	<body style="padding: 15px">
		<%@ include file="/WEB-INF/view/menu.jspf" %>
	
		<table>
			
			<td style="padding-left: 30px" valign="top">
				<form class="pure-form" method="post" action="/Product/user/update" >
					<fieldset>
						<legend>User 修改密碼 ${message} </legend>
						<input type="hidden" name="userId" value="${userCert.userId} " readonly /><p /> 
						帳號名: <input type="text" name="username" value="${userCert.userName} " readonly /><p />
						舊密碼: <input type="text" name="oldpassword"><p /> 
						新密碼: <input type="text" name="newpassword"><p />
						<button type="submit" class="button-success pure-button">Update Password</button>	  
					</fieldset>
				</form>
			</td>
		</table>
		
	</body>
</html>