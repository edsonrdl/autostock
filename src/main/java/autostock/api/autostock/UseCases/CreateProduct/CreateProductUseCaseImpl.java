package autostock.api.autostock.UseCases.CreateProduct;

import org.springframework.beans.factory.annotation.Autowired;

import autostock.api.autostock.Entities.Product;
import autostock.api.autostock.Repository.ProductRepository;
import jakarta.transaction.Transactional;

public class CreateProductUseCaseImpl implements ICreateProductUseCase {
    
    @Autowired
    private  ProductRepository _productRepository;

    public CreateProductUseCaseImpl(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    @Transactional
    public Product execute(Product product) {
        product.setId((null));
        _productRepository.save(product);
        return product;
    }

}
