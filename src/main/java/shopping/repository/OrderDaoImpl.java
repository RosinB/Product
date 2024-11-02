package shopping.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import shopping.model.entity.*;


public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public Order FindOrderById(Integer UserId){
		String sql="""
				select user_id, order_date, product_id, quantity, unit_price, subtotal, order_status
				from orders
				where user_id=? 
				""".trim();
		Order order=new Order();
		try(PreparedStatement pstmt =conn.prepareStatement(sql)) {
			pstmt.setInt(1, UserId);
			
			try(ResultSet rs=pstmt.executeQuery()){
				;
				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getString("order_date"));
				order.setProductId(rs.getInt("product_id"));
				order.setQuantity(rs.getInt("quantity"));
				order.setUnitPrice(rs.getBigDecimal("unit_price"));
				order.setSubtotal(rs.getBigDecimal("subtotal"));
				order.setOrderStatus(rs.getString("order_status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

}
