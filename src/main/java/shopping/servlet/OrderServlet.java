package shopping.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shopping.model.dto.OrderDto;
import shopping.service.OrderService;


@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	OrderService orderService =new OrderService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String userIdParam = req.getParameter("userid");
	  

	    Integer userId;
	    try {
	        userId = Integer.parseInt(userIdParam);
	    } catch (NumberFormatException e) {
	        req.setAttribute("error", "Invalid User ID format.");
	        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
	        return;
	    }

	    // 查詢訂單
	    OrderDto orderDto = orderService.findOrderState(userId);
	    System.out.println("我在servlt "+orderDto);
	    if (orderDto == null) {
	        req.setAttribute("error", "No order found for the provided User ID.");
	    } else {
	        req.setAttribute("orderDto", orderDto);
	    }

	    req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
	}

	
	
	
}
