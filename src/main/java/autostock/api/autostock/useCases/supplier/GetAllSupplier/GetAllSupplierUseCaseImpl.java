package autostock.api.autostock.useCases.supplier.GetAllSupplier;

import java.util.List;

import org.springframework.stereotype.Component;

import autostock.api.autostock.entities.Supplier;
import autostock.api.autostock.repository.SupplierRepository;
import jakarta.transaction.Transactional;

@Component
public class GetAllSupplierUseCaseImpl  implements IGetAllSupplierUseCase{
    
    private final SupplierRepository _supplierRepository;

    public GetAllSupplierUseCaseImpl(SupplierRepository supplierRepository){
        _supplierRepository=supplierRepository;
    }

    @Transactional
    public List<Supplier> getAllSupplier(){
        return _supplierRepository.findAll();
    }

}
