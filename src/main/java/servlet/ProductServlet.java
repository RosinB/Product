package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.ProductDto;
import service.ProductService;

@WebServlet(urlPatterns = { "/product", "/product/*" })

public class ProductServlet extends HttpServlet {

	private ProductService productService = new ProductService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		if (pathInfo == null||pathInfo.equals("/*")) {
			List<ProductDto> productDtos = productService.findAll();
			req.setAttribute("productDtos", productDtos);

			req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req, resp);
			return;

		}else if(pathInfo.equals("/delete")) {
			
				String productId=req.getParameter("productId");
				productService.deleteProduct(productId);
				resp.sendRedirect("/Product/product");
				return;		
		}else if(pathInfo.equals("/get")) {
				String productName=req.getParameter("productName");

				ProductDto productDto=productService.getProduct(productName);
				if (productDto == null) {
			        // 若找不到產品，重新導向或顯示錯誤訊息
			        req.setAttribute("error", "找不到指定的產品");
			        req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req, resp);
			        return;
			    }
				req.setAttribute("productDto", productDto);
				req.getRequestDispatcher("/WEB-INF/view/product_update.jsp").forward(req, resp);
				return;
			
			
				
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String productname = req.getParameter("productname");
		String priceString = req.getParameter("price");
		String stockquantityString = req.getParameter("stockquantity");
		String productId=req.getParameter("productId");
	
		
		BigDecimal price = new BigDecimal(priceString);
		Integer stockquantity = Integer.parseInt(stockquantityString);
		switch (pathInfo) {
		case "/add":
			productService.appendProduct(productname, price, stockquantity);
			break;
		case "/update":
			productService.updateProduct(productId,productname);
			break;
		}
		resp.sendRedirect("/Product/product");

	}

}
