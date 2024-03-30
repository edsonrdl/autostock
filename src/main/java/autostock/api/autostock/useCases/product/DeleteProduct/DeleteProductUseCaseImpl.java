package autostock.api.autostock.useCases.product.DeleteProduct;


import org.springframework.stereotype.Component;

import autostock.api.autostock.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Component
public class DeleteProductUseCaseImpl implements IDeleteProductUseCase {

    private final  ProductRepository _productRepository;

    public  DeleteProductUseCaseImpl(ProductRepository productRepository) {
        _productRepository=productRepository;
    
}
@Transactional
public void deleteProduct(Long id){
        try {
          _productRepository.deleteById(id);

        } catch (Exception e) {
            throw new RuntimeException("Não é possível deletar");
        }
}
}
