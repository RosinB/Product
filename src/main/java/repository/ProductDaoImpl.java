package repository;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<Product>();
		String sql = "select product_id ,product_name , price ,stock_quantity from product";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))

		{
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setStockQuantity(rs.getInt("stock_quantity"));
				products.add(product);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public Product getProduct(String productName) {

		String sql = "select product_id,product_name,price,stock_quantity from product where product_name=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,productName);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {

					Product product = new Product();
					product.setProductId(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getBigDecimal("price"));
					product.setStockQuantity(rs.getInt("stock_quantity"));
					return product;

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into  product(product_name,price ,stock_quantity) values(?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getProductName());
			pstmt.setBigDecimal(2, product.getPrice());
			pstmt.setInt(3, product.getStockQuantity());
			
			int rowcount=pstmt.executeUpdate();
			if(rowcount!=1) {
				throw new RuntimeException("新增失敗");
			}

			}
		 catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProduct(Integer productId) {
		String sql="delete from product where product_id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
		
			pstmt.setInt(1, productId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount != 1) {
					throw new RuntimeException("刪除失敗 Product Id:"+productId);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		
		
		
	}

	@Override
	public void updateProductName(Integer productID, String productName) {
		String sql="update product set  product_name=?  where product_id=?";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1,productName);
			pstmt.setInt(2,productID);
			
			System.out.println(productID+productName);
			int rowcount=pstmt.executeUpdate();
			if(rowcount!=1) {
					throw new RuntimeException("修改失敗");			
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	
	

}
