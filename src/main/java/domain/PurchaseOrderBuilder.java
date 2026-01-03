package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBuilder {

	private OrderId id;
	private CustomerId customerId;
	private final List<OrderItem> items = new ArrayList<>();
	
	public PurchaseOrderBuilder withId(
			final OrderId id) {
		this.id = id;
		return this;
	}
	
	public PurchaseOrderBuilder forCustomer(
			final CustomerId customerId) {
		this.customerId = customerId;
		return this;
	}
	
	public PurchaseOrderBuilder addItem(
			final OrderItem item) {
		this.items.add(item);
		return this;
	}
	
	public PurchaseOrder build() {
		validate();
		BigDecimal total = items.stream()
				.map(OrderItem::total)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		return new PurchaseOrder(
				id, 
				customerId, 
				items, 
				total, OrderStatus.CREATED);
	}

	private void validate() {
		if(id == null) throw new IllegalStateException("OrderId is required");
		if(customerId == null) throw new IllegalStateException("CustomerId is required");
		if(items.isEmpty()) throw new IllegalStateException("Order must contain at least one item");
	}
	
}
