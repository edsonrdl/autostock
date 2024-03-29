package autostock.api.autostock.Mapper;

import autostock.api.autostock.Entities.Supplier;
import autostock.api.autostock.Models.SupplierModel;

public class SupplierMapper {
    public static Supplier mapToEntity(SupplierModel supplierModel) {
        Supplier supplier = new Supplier();

        supplier.setName(supplierModel.getName());
        supplier.setDescription(supplierModel.getDescription());
        supplier.setProduct(supplierModel.getProduct());
        return supplier;
    }
    
}
