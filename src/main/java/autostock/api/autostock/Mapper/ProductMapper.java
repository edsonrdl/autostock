package autostock.api.autostock.Mapper;

import autostock.api.autostock.Entities.Product;
import autostock.api.autostock.Models.ProductModel;

public class ProductMapper {
     public static Product mapToEntity(ProductModel productModel) {
        Product product = new Product();
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());
        product.setDescription(productModel.getDescription());
        product.setAmount(productModel.getAmount());
        product.setAmountMinimum(productModel.getAmountMinimum());
        product.setSupplier(productModel.getSupplier());
        return product;
    }
}
