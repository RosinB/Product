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
				select order_id, order_date, product_id, quantity, unit_price, subtotal, order_status
				from orders
				where user_id=? 
				""".trim();
		Order order=new Order();
		try(PreparedStatement pstmt =conn.prepareStatement(sql)) {
			pstmt.setInt(1, UserId);
			
			try(ResultSet rs=pstmt.executeQuery()){
				
				if (rs.next()) {  // 如果查詢結果存在
                    order = new Order();
                    order.setOrderId(rs.getInt("order_id"));
                    order.setUserId(rs.getInt("user_id"));
                    order.setOrderDate(rs.getString("order_date"));
                    order.setProductId(rs.getInt("product_id"));
                    order.setQuantity(rs.getInt("quantity"));
                    order.setUnitPrice(rs.getBigDecimal("unit_price"));
                    order.setSubtotal(rs.getBigDecimal("subtotal"));
                    order.setOrderStatus(rs.getString("order_status"));
                }
			}
			
		} catch (SQLException e) {
			System.out.println("我在daoimpl 我報錯了");
			e.printStackTrace();
		}
		System.out.println("我在daoimpl"+order);
		return order;
	}

}
