package autostock.api.autostock.useCases.product.CreateProduct;

import autostock.api.autostock.entities.Product;

public interface ICreateProductUseCase {
    Product createProduct(Product product);
}
