package shopping.repository;

import java.util.List;

import shopping.model.entity.Product;

public interface ProductDao {
	
	List<Product> findAllProducts();
	
//	查單筆
	Product getProduct(String productName);
//添加單筆
	void addProduct(Product product);
//刪除
	void deleteProduct(Integer productId);
	
	void updateProductName(Integer ProductID,String productName);
	
}
