<%@page import="shopping.model.dto.OrderDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Lookup</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    <style>
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f4f4f9;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }

        .order-info {
            background-color: #e9f7ef;
            padding: 10px;
            border-radius: 4px;
        }

        .order-info p {
            margin: 8px 0;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container pure-form pure-form-stacked">
        <h2>Order Lookup</h2>

        <!-- Error message -->
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <div class="error"><%= error %></div>
        <% } %>

        <!-- Order lookup form -->
        <form action="/Product/order" method="post">
            <label for="userid">Enter User ID:</label>
            <input type="text" id="userid" name="userid" placeholder="Enter your User ID" required>
            <button type="submit" class="pure-button pure-button-primary">Lookup Order</button>
        </form>

        <!-- Display order information if available -->
        <% OrderDto orderDto = (OrderDto) request.getAttribute("orderDto"); %>
        <% if (orderDto != null) { %>
            <div class="order-info">
                <p><strong>Order ID:</strong> <%= orderDto.getOrderId() %></p>
                <p><strong>User ID:</strong> <%= orderDto.getUserId() %></p>
                <p><strong>Order Date:</strong> <%= orderDto.getOrderDate() %></p>
                <p><strong>Product ID:</strong> <%= orderDto.getProductId() %></p>
                <p><strong>Quantity:</strong> <%= orderDto.getQuantity() %></p>
                <p><strong>Unit Price:</strong> <%= orderDto.getUnitPrice() %></p>
                <p><strong>Subtotal:</strong> <%= orderDto.getSubtotal() %></p>
                <p><strong>Order Status:</strong> <%= orderDto.getOrderStatus() %></p>
            </div>
        <% } %>
    </div>
</body>
</html>