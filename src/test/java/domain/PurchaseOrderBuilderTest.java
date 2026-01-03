package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class PurchaseOrderBuilderTest {

	@Test
	void shouldBuildValidPurchaseOrder() {
		PurchaseOrder order = new PurchaseOrderBuilder()
				.withId(new OrderId("order-id"))
				.forCustomer(new CustomerId("customer-id"))
				.addItem(new OrderItem("prod-1", 2, BigDecimal.TEN))
				.addItem(new OrderItem("prod-2", 1, BigDecimal.valueOf(5)))
				.build();
		
		assertEquals(BigDecimal.valueOf(25), order.getTotalAmount());
		assertEquals(OrderStatus.CREATED, order.getStatus());
	}

	@Test
	void shouldFailWhenNoItems() {
		PurchaseOrderBuilder builder = new PurchaseOrderBuilder()
				.withId(new OrderId("order-id"))
				.forCustomer(new CustomerId("customer-id"));
		assertThrows(IllegalStateException.class, () -> {
			builder.build();
		});
	}
	
}
