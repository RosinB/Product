package shopping.service;

import java.util.ArrayList;
import java.util.List;

import shopping.model.dto.OrderDto;
import shopping.model.entity.Order;
import shopping.repository.OrderDao;
import shopping.repository.OrderDaoImpl;


public class OrderService {
	OrderDao  orderDao =new OrderDaoImpl();

	
	public OrderDto findOrderState(Integer UserId) {
		Order order=orderDao.FindOrderById(UserId);
		
		if(order==null) {
			
			System.out.println("我在orderService 找不到訂單");
			return null;
		}
		
		OrderDto orders=new OrderDto();
		
		orders.setOrderId(order.getOrderId());
		orders.setUserId(order.getUserId());
		orders.setOrderDate(order.getOrderDate());
		orders.setProductId(order.getProductId());
		orders.setQuantity(order.getQuantity());
		orders.setUnitPrice(order.getUnitPrice());
		orders.setSubtotal(order.getSubtotal());
		orders.setOrderStatus(order.getOrderStatus());
		
		return orders;
	}
	
	
}
