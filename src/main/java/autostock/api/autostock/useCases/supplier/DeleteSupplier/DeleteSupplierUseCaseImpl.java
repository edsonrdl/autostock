package autostock.api.autostock.useCases.supplier.DeleteSupplier;

import org.springframework.stereotype.Component;

import autostock.api.autostock.repository.SupplierRepository;
import jakarta.transaction.Transactional;

@Component
public class DeleteSupplierUseCaseImpl implements IDeleteSupplierUseCase {

    private final SupplierRepository _supplierRepository;

    public DeleteSupplierUseCaseImpl(SupplierRepository supplierRepository) {
        _supplierRepository = supplierRepository;
    }

    @Transactional
    public void deleteSupplier(Long id) {

        try {
            _supplierRepository.deleteById(id);

        } catch (Exception e) {
            throw new RuntimeException("Não é possível deletar");
        }
    }

}