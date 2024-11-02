package shopping.repository;

import java.util.List;
import shopping.model.entity.*;


public interface OrderDao {
	
	//查詢該使用者的訂單
	public Order FindOrderById(Integer UserId);
	
	
	
}
