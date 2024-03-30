package autostock.api.autostock.mapper;

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.models.ProductModel;

public class ProductMapper {
     public static Product mapToEntity(ProductModel productModel) {
        Product product = new Product();
        product.setName(productModel.getName());
        product.setValue(productModel.getValue());
        product.setDescription(productModel.getDescription());
        product.setAmount(productModel.getAmount());
        product.setAmountMinimum(productModel.getAmountMinimum());
        if(productModel.getSupplierModel() != null) {
            product.setSupplier(SupplierMapper.mapToEntity(productModel.getSupplierModel()));
        }
        return product;
    }
}
