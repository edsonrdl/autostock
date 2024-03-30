package autostock.api.autostock.services.product.GetAllProductsInSupplier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.entities.Supplier;
import autostock.api.autostock.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class GetAllProductsInSupplierService {

    private final ProductRepository _productRepository;

    public  GetAllProductsInSupplierService(ProductRepository productRepository){
        _productRepository=productRepository;
    }

 @Transactional
    public List<Product> getAllProductsInSupplier(String supplierName) {
        List<Product> validProductsAmountMinimum = new ArrayList<>();
        Set<Long> addedProductIds = new HashSet<>();

        List<Product> products = _productRepository.findAll();

        for (Product product : products) {
            Supplier supplier = product.getSupplier();
            if (supplier != null && supplier.getName().equals(supplierName)) {
                List<Product> productsInSupplier = supplier.getProduct();
                for (Product productSupplier : productsInSupplier) {
                    if (productSupplier.getAmount() <= productSupplier.getAmountMinimum()) {
                        if (!addedProductIds.contains(productSupplier.getId())) {
                            validProductsAmountMinimum.add(productSupplier);
                            addedProductIds.add(productSupplier.getId());
                        }
                    }
                }
            }
        }
        return validProductsAmountMinimum;
    }
}
