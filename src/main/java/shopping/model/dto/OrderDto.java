package shopping.model.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class OrderDto {
	private Integer OrderId;
	private Integer UserId;
	private String OrderDate;
	private Integer ProductId;
	private Integer Quantity;
	private BigDecimal UnitPrice;
	private BigDecimal Subtotal;
	private String OrderStatus;
}
