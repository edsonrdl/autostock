package autostock.api.autostock.useCases.product.DeleteProduct;


import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import autostock.api.autostock.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Component
public class DeleteProductUseCaseImpl implements IDeleteProductUseCase {

    private final  ProductRepository _productRepository;

    public  DeleteProductUseCaseImpl(ProductRepository productRepository) {
        _productRepository=productRepository;
    
}
@SuppressWarnings("null")
@Transactional
public void deleteProduct(Long id){
    try {
        if (_productRepository.existsById(id)) {
            _productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto não encontrado com o ID fornecido: " + id);
        }
    } catch (EntityNotFoundException e) {
        throw e; 
    } catch (Exception e) {
        throw new RuntimeException("Não é possível deletar o produto com o ID: " + id, e);
    }
}
}
