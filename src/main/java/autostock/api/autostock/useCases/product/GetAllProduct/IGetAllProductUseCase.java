package autostock.api.autostock.useCases.product.GetAllProduct;

import java.util.List; 

import autostock.api.autostock.entities.Product;

public interface IGetAllProductUseCase {

    List<Product> getAllProduct();
    
}
