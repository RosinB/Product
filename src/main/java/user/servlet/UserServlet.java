package user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.dto.UserCert;
import user.dto.UserDto;
import user.service.UserService;

@WebServlet(urlPatterns = {"/user/*","/user"})
public class UserServlet extends HttpServlet {
	UserService userService=new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo=req.getPathInfo();
		String username ="jack";
		if(pathInfo==null) {
			List<UserDto> userdto=userService.findAll();

			req.setAttribute("userdto", userdto);

			req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
			return;
		}
		if(pathInfo.equals("/update")) {
			
			req.getRequestDispatcher("/WEB-INF/view/userupdate.jsp").forward(req, resp);

		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId=req.getParameter("userId");
		String userName=req.getParameter("username");
		String oldPassWord=req.getParameter("oldpassword");
		String newPassWord=req.getParameter("newpassword");
		String pathInfo=req.getPathInfo();
		switch(pathInfo) {
		case "/update":
					HttpSession session=req.getSession();
					try {
						UserCert userCert=(UserCert)session.getAttribute("userCert");
						userService.updatePassword(userCert.getUserId(), userCert.getUserName(), oldPassWord, newPassWord);
						req.setAttribute("message", "密碼更新成功");
						req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
					} catch (Exception e) {
						req.setAttribute("message","密碼更新失敗");
						req.getRequestDispatcher("/WEB-INF/view/userupdate.jsp").forward(req, resp);

					}
					break;
		}
		
		
		
		
		
		
		
		
	}

}
