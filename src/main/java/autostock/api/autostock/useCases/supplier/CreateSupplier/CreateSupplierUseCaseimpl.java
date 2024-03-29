package autostock.api.autostock.useCases.supplier.CreateSupplier;

import autostock.api.autostock.entities.Supplier;
import autostock.api.autostock.repository.SupplierRepository;
import jakarta.transaction.Transactional;

public class CreateSupplierUseCaseimpl implements ICreateSupplierUseCase {

    private final SupplierRepository _supplierRepository;

    public CreateSupplierUseCaseimpl(SupplierRepository supplierRepository){
        _supplierRepository=supplierRepository;
    }

    @Transactional
    public Supplier createSupplier(Supplier supplier){
        supplier.setId((null));
        _supplierRepository.save(supplier);
        return supplier;
    }
    
}
