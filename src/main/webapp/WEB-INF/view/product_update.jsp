<%@page import="model.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 得到 UserServlet 所傳來的資料
	ProductDto productDto = (ProductDto)request.getAttribute("productDto");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
			<link rel="stylesheet" href="/Product/css/buttons.css">
	</head>
	<body style="padding:15px">
	<form class="pure-form" method="post" action="/Product/product/update">
			<fieldset>
				<legend>Product 修改</legend>
				<input type="hidden" name="productId" value="<%=productDto.getProductId() %>">
				
				productname: <input type="text" name="productname"  value="<%=productDto.getProductName()%>"/>
				<p /> 
				price: <input type="text" name="price"  value="<%=productDto.getPrice() %>" readonly/>  
				<p /> 
				stockquantity: <input type="text" name="stockquantity"  readonly value="<%=productDto.getStockQuantity()%>"/>
				<p />
					
				<button type="submit" class="button-success pure-button">Submit</button>  
			</fieldset>
		</form>
		
	</body>
</html>