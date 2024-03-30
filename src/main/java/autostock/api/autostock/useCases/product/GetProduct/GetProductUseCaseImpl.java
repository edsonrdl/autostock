package autostock.api.autostock.useCases.product.GetProduct;

import org.springframework.stereotype.Component;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Component
public class GetProductUseCaseImpl implements IGetProductUseCase {
    
    private final ProductRepository _productRepository;

    public GetProductUseCaseImpl(ProductRepository productRepository){
        _productRepository = productRepository;
    }

    @Transactional
    public Product getProduct(Long id){
        return _productRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException(
            "Produto não encontrado!"+id +",tipo" + Product.class.getSimpleName()));
    }
    
}
