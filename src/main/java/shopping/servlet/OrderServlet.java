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
		Integer UserId= Integer.parseInt(req.getParameter("userid"));
		OrderDto orderDto=orderService.findOrderState(UserId);
		req.setAttribute("orderDto", orderDto);

		req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);

		
	}

	
	
	
}
