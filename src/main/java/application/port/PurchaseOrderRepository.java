package application.port;

import domain.PurchaseOrder;

public interface PurchaseOrderRepository {
	void save(PurchaseOrder order);
}
