package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.dto.ProductDto;
import model.entity.Product;
import repository.ProductDao;
import repository.ProductDaoImpl;

public class ProductService {
		private ProductDao productDao=new ProductDaoImpl();
		
		public List<ProductDto> findAll(){
			List<ProductDto> productDtos=new ArrayList<ProductDto>();
			
			List<Product> products=productDao.findAllProducts();
			for(Product product:products) {
				ProductDto productDto=new ProductDto();
				productDto.setProductId(product.getProductId());
				productDto.setProductName(product.getProductName());
				productDto.setPrice(product.getPrice());
				productDto.setStockQuantity(product.getStockQuantity());

				productDtos.add(productDto);
			}
			
			
			return productDtos;
		}
		
		public void appendProduct(String productName,BigDecimal price, Integer stockQuantity) {
			Product product =new Product();
			product.setProductName(productName);
			product.setPrice(price);
			product.setStockQuantity(stockQuantity);
			
			productDao.addProduct(product);
			
			
		}
		public void deleteProduct(String productId) {
			productDao.deleteProduct(Integer.parseInt(productId));
			
			
		}
		public ProductDto getProduct(String productName) {
			Product product=productDao.getProduct(productName);
			if(product==null) {
				
		        return new ProductDto(); // 返回空的 ProductDto，避免 null
			}
			
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setPrice(product.getPrice());
			productDto.setStockQuantity(product.getStockQuantity());;
			return productDto;		
		}
		
		
		
		
		
			public void updateProduct(String productId,String productName) {
				if(!productName.isEmpty()) {	
					productDao.updateProductName(Integer.parseInt(productId), productName);	
				}
					
		}	
		
}
