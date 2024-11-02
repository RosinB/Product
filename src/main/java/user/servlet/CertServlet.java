package user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.dto.UserCert;
import user.service.CertService;
@WebServlet("/login")
public class CertServlet extends HttpServlet{
	CertService certService =new CertService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String passowrd=req.getParameter("password");
		UserCert userCert=null;
		try {
			userCert=certService.getCert(username, passowrd);

		} catch (Exception e) {
			req.setAttribute("message"," 密碼錯誤，請重試" );
			req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
			return;
		}
		HttpSession session =req.getSession();
		session.setAttribute("userCert",userCert);
		req.setAttribute("message","登入成功");
		// 檢查 session 中的 redirectURL 是否有資料 ?
		if(session.getAttribute("redirectURL")==null){			
			req.getRequestDispatcher("index").forward(req, resp);
		}else {
			String redirectURL=session.getAttribute("redirectURL").toString();
			resp.sendRedirect(redirectURL);
			session.setAttribute("redirectURL", null);
		}

		
		
		
	}

	
	
}
