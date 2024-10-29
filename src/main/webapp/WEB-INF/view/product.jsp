<%@page import="model.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 得到 UserServlet 所傳來的資料
	List<ProductDto> productDtos = (List<ProductDto>)request.getAttribute("productDtos");
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
	<form class="pure-form" method="post" action="/Product/product/add">
			<fieldset>
				<legend>Product 新增</legend>
				productname: <input type="text" name="productname" placeholder="請輸入 productname" required /><p /> 
				price: <input type="text" name="price" placeholder="請輸入 price" required /><p /> 
				stockquantity: <input type="text" name="stockquantity" placeholder="stockquantity " required /><p />
					
					<button type="reset" class="button-warning pure-button">Reset</button>
				<button type="submit" class="button-success pure-button">Submit</button>  
			</fieldset>
		</form>
		<p />
		<div class="pure-form">
			<fieldset>
				<legend>Product 列表</legend>
				<table  class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>ID</th><th>商品名</th><th>價錢</th><th>股價</th><th>修改</th><th>刪除</th>
						</tr>
					</thead>
					<% for(ProductDto productDto : productDtos) { %>
						<tr>
							<td><%=productDto.getProductId() %></td>
							<td><%=productDto.getProductName() %></td>
							<td><%=productDto.getPrice() %></td>
							<td><%=productDto.getStockQuantity() %></td>
							<td><a href="/Product/product/get?productName=<%=productDto.getProductName() %>" class="button-secondary pure-button">修改</a></td>							
							
							<td><a href="/Product/product/delete?productId=<%=productDto.getProductId() %>" class="button-secondary pure-button">刪除</a></td>
						</tr>
					<% } %>
				</table>
			</fieldset>
		</div>
	</body>
</html>