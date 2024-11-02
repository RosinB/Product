package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/user/update","/shopping/*","/user"})
public class LoginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session=req.getSession();
		if(session.getAttribute("userCert")==null) {
			res.getWriter().println("請先登入");
			 //記住此次請求的 URL
			session.setAttribute("redirectURL", req.getRequestURL());
			res.sendRedirect("/Product/login"); // 自動重導到登入頁面
			
			
		}else {
			
			chain.doFilter(req, res);
		}
		
		
		
	}

}
