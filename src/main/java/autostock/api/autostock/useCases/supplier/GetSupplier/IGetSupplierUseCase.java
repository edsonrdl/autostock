package autostock.api.autostock.useCases.supplier.GetSupplier;

import autostock.api.autostock.entities.Supplier;

public interface IGetSupplierUseCase {
    Supplier getSupplier(Long id);
}
