package user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.dto.UserDto;
import user.service.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	UserService userService=new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo=req.getPathInfo();
		String username ="jack";
		if(pathInfo==null) {
			List<UserDto> userdto=userService.findAll();
			System.out.println(userdto);

			req.setAttribute("userdto", userdto);

			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
			return;
		}
		
		
	}

}
