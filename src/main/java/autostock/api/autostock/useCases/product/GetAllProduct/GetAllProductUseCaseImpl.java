package autostock.api.autostock.useCases.product.GetAllProduct;



import java.util.List;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.repository.ProductRepository;

public class GetAllProductUseCaseImpl implements IGetAllProductUseCase {

    private  final ProductRepository _productRepository;

    public GetAllProductUseCaseImpl(ProductRepository productRepository){
        _productRepository=productRepository;
    }

    public List<Product> getAllProduct(){
        return _productRepository.findAll();
    }
    
}
