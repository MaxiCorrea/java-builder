package application;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import application.port.PurchaseOrderRepository;
import application.usecase.CreatePurchaseOrderUseCase;
import domain.CustomerId;
import domain.OrderId;
import domain.OrderItem;
import domain.PurchaseOrder;
import domain.PurchaseOrderBuilder;

class CreatePurchaseOrderUseCaseTest {

	@Test
	void shouldSaveOrder() {
		PurchaseOrderRepository repository = Mockito.mock(PurchaseOrderRepository.class);
		CreatePurchaseOrderUseCase usecase = new CreatePurchaseOrderUseCase(repository);
		
		PurchaseOrderBuilder builder = new PurchaseOrderBuilder()
				.withId(new OrderId("order-1"))
				.forCustomer(new CustomerId("customer-1"))
				.addItem(new OrderItem("prod-1", 1 , BigDecimal.TEN));
				
		usecase.execute(builder);
		Mockito.verify(repository).save(Mockito.any(PurchaseOrder.class));
	}

}
