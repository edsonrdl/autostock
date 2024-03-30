package autostock.api.autostock.useCases.product.GetAllProductAmountMinimum;

import java.util.List;

import org.springframework.stereotype.Component;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Component
public class GetAllProductAmountMinimun implements IGetAllProductAmountMinimun{

    private final ProductRepository _productRepository;

    public GetAllProductAmountMinimun(ProductRepository productRepository){
        _productRepository=productRepository;
    }

    @Transactional
    public List<Product> getAllProductAmountMinimum(Long supplierId, int amountMinimum) {
        List<Product> products =_productRepository.findBySupplierIdAndAmountLessThanEqual(supplierId, amountMinimum);
        return products;
    }
    
}
