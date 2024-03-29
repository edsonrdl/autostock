package autostock.api.autostock.useCases.supplier.UpdateSupplier;

import autostock.api.autostock.entities.Supplier;
import autostock.api.autostock.repository.SupplierRepository;
import jakarta.transaction.Transactional;

public class UpdateSupplierUseCaseImpl implements IUpdateSupplierUseCase {

    private final SupplierRepository _supplierRepository;

    public UpdateSupplierUseCaseImpl(SupplierRepository supplierRepository) {
    _supplierRepository=supplierRepository;

}
    @Transactional
    public Supplier updateSupplier(Supplier objSuppler){
        Supplier supplier=_supplierRepository.findById(objSuppler.getId()).orElse(null);;
        if (supplier==null) {
            return null;
        }
        supplier.setName(objSuppler.getName());
        supplier.setDescription(objSuppler.getDescription());
        return _supplierRepository.save(supplier); 
    }
}