package autostock.api.autostock.useCases.product.DeleteProduct;


import autostock.api.autostock.repository.ProductRepository;
import jakarta.transaction.Transactional;

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
