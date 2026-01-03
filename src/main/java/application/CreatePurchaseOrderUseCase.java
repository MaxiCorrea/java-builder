package application;

import domain.PurchaseOrder;
import domain.PurchaseOrderBuilder;
import domain.port.PurchaseOrderRepository;

public class CreatePurchaseOrderUseCase {

	private final PurchaseOrderRepository repository;
	
	public CreatePurchaseOrderUseCase(
			final PurchaseOrderRepository repository) {
		this.repository = repository;
	}
	
	public void execute(
			PurchaseOrderBuilder builder) {
		PurchaseOrder order = builder.build();
		repository.save(order);
	}
	
}
