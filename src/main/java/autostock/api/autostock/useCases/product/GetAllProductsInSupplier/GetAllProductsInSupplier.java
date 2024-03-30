package autostock.api.autostock.useCases.product.GetAllProductsInSupplier;

import java.util.List;
import org.springframework.stereotype.Component;
import autostock.api.autostock.entities.Product;
import autostock.api.autostock.services.product.GetAllProductsInSupplier.GetAllProductsInSupplierService;
import jakarta.transaction.Transactional;

@Component
public class GetAllProductsInSupplier implements IGetAllProductsInSupplier{

    private final GetAllProductsInSupplierService _getAllProductsInSupplierService;

    public GetAllProductsInSupplier(GetAllProductsInSupplierService getAllProductsInSupplierService){
        _getAllProductsInSupplierService=getAllProductsInSupplierService;
    }

    @Transactional
    public List<Product> getAllProductsInSupplier(String supplierName) {
        return _getAllProductsInSupplierService.getAllProductsInSupplier(supplierName);
    }
}
