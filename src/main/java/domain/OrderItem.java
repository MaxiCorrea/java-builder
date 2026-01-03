package domain;

import java.math.BigDecimal;

public class OrderItem {

	private final String productId;
	private final int quantity;
	private final BigDecimal unitPrice;
	
	public OrderItem(
			final String productId,
			final int quantity,
			final BigDecimal unitPrice) {
		if(quantity <= 0 )
			throw new IllegalArgumentException("Quantity must be positive");
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public BigDecimal total() {
		return unitPrice.multiply(BigDecimal.valueOf(quantity));
	}
	
}
