package domain;

import static java.util.Collections.unmodifiableList;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrder {

	private final OrderId id;
	private final CustomerId customerId;
	private final List<OrderItem> items;
	private final BigDecimal totalAmount;
	private final OrderStatus status;
	
	PurchaseOrder(
			final OrderId id,
			final CustomerId customerId,
			final List<OrderItem> items,
			final BigDecimal totalAmount,
			final OrderStatus status) {
		this.id = id;
		this.customerId = customerId;
		this.items = items;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	public OrderId getId() {
		return id;
	}
	
	public CustomerId getCustomerId() {
		return customerId;
	}
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	public List<OrderItem> getItems() {
		return unmodifiableList(items);
	}
	
	public OrderStatus getStatus() {
		return status;
	}	
}
