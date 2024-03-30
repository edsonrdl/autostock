package autostock.api.autostock.useCases.product.UpdateProduct;

import org.springframework.stereotype.Component;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Component
public class UpdateProductUseCaseImpl implements IUpdateProductUseCase {
     private ProductRepository _productRepository;

     public  UpdateProductUseCaseImpl(ProductRepository productRepository){
        _productRepository=productRepository;
     }

     @Transactional
     public Product updateProduct(Product objProduct){
       Product product = _productRepository.findById(objProduct.getId()).orElse(null);
        if (product==null) {
            return  null;
        }
        product.setName(objProduct.getName());
        product.setPrice(objProduct.getPrice());
        product.setDescription(objProduct.getDescription());
        product.setAmount(objProduct.getAmount());
        product.setAmountMinimum(objProduct.getAmountMinimum());
        return _productRepository.save(product); 
     }
}
