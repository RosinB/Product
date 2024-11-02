<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="user.dto.*"%>
<%@page import="java.util.List"%>

<%
List<UserDto> userdtos = (List<UserDto>) request.getAttribute("userdto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User 列表</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="/Product/css/buttons.css">
<style>
    body {
        padding: 15px;
        font-family: Arial, sans-serif;
        text-align: center;
    }
    .pure-form {
        display: inline-block;
        width: 80%;
        max-width: 600px;
    }
    .pure-table {
        width: 100%;
        margin: 0 auto;
        border-collapse: collapse;
    }
    .pure-table thead th {
        background-color: #1f8dd6;
        color: #fff;
        font-weight: bold;
    }
    .pure-table td, .pure-table th {
        text-align: center;
        padding: 10px;
    }
    .pure-table tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    .pure-table tbody tr:hover {
        background-color: #e0e0e0;
    }
</style>
</head>
	<%@ include file="/WEB-INF/view/menu.jspf" %>

<body>

<div class="pure-form">
    <fieldset>
        <legend>User 列表</legend>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>帳號名</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (UserDto users : userdtos) {
                %>
                <tr>
                    <td><%=users.getUserId()%></td>
                    <td><%=users.getUserName()%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </fieldset>
</div>

</body>
</html>
