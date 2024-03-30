package autostock.api.autostock.useCases.product.CreateProduct;

import org.springframework.stereotype.Component;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Component
public class CreateProductUseCaseImpl implements ICreateProductUseCase {
    
    private final  ProductRepository _productRepository;

    public CreateProductUseCaseImpl(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(Product product) {
        product.setId((null));
        _productRepository.save(product);
        return product;
    }

}
