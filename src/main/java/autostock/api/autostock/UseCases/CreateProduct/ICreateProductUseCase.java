package autostock.api.autostock.UseCases.CreateProduct;

import autostock.api.autostock.Entities.Product;

public interface ICreateProductUseCase {
    Product execute(Product product);
}
