package autostock.api.autostock.useCases.supplier.GetSupplier;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.entities.Supplier;
import autostock.api.autostock.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

public class GetSupplieruseCaseimpl implements IGetSupplierUseCase {
     private final SupplierRepository _supplierRepository;


     public GetSupplieruseCaseimpl(SupplierRepository supplierRepository){
        _supplierRepository=supplierRepository;
}
    @Transactional
    public Supplier getSupplier(Long id){
        return _supplierRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
            "Fornecedor não encontrado!"+id +",tipo" + Supplier.class.getSimpleName()));
    }
}
