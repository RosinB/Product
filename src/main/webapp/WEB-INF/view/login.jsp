<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="user.dto.*"%>
   <%@page import="java.util.List"%>
   
<% 
  	List<UserDto> userdtos= (List<UserDto>) request.getAttribute("userdto"); 
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
				<legend>User 列表</legend>
				<table  class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>ID</th><th>商品名</th>
						</tr>
					</thead>
					
	
					<% for(UserDto users : userdtos) { %>
						<tr>
							<td><%=users.getUserId() %></td>
							<td><%=users.getUserName() %></td>
						</tr>
					<% } %>
				</table>
			</fieldset>
				</table>
			</fieldset>

	
</body>
</html>