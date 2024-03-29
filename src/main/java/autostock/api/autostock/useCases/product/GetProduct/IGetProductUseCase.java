package autostock.api.autostock.useCases.product.GetProduct;

import autostock.api.autostock.entities.Product;

public interface IGetProductUseCase {
    Product getProduct(Long id);
}
