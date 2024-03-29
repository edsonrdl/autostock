package autostock.api.autostock.mapper;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.models.ProductModel;

public class ProductMapper {
     public static Product mapToEntity(ProductModel productModel) {
        Product product = new Product();
        product.setId(productModel.getId());
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());
        product.setDescription(productModel.getDescription());
        product.setAmount(productModel.getAmount());
        product.setAmountMinimum(productModel.getAmountMinimum());
        product.setSupplier(productModel.getSupplier());
        return product;
    }
}
