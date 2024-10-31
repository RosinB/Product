<%@page import="user.dto.UserCert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User 創建</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/javaweb/css/buttons.css">
	</head>
	<body style="padding: 15px">
		<table>
			
			<td style="padding-left: 30px" valign="top">
				<form class="pure-form" method="post" action="/Product/user/add" >
					<fieldset>
						<legend>User 創建帳號 ${message} </legend>
						<input type="hidden" name="userId"   /><p /> 
						帳號名: <input type="text" name="username"  /><p />
						密碼: <input type="text" name="password"><p />
						<button type="submit" class="button-success pure-button">創建按鈕</button>	  
					</fieldset>
				</form>
			</td>
		</table>
		
	</body>
</html>