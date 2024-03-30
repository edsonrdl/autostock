package autostock.api.autostock.useCases.product.GetAllProductsInSupplier;

import java.util.List;

import autostock.api.autostock.entities.Product;

public interface IGetAllProductsInSupplier {
    List<Product> getAllProductsInSupplier(String supplierName);
}
