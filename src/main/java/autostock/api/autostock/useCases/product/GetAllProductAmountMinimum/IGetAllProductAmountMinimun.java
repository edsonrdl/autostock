package autostock.api.autostock.useCases.product.GetAllProductAmountMinimum;

import java.util.List;

import autostock.api.autostock.entities.Product;

public interface IGetAllProductAmountMinimun {
    List<Product> getAllProductAmountMinimum(Long supplierId, int amountMinimum);
}
