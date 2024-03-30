package autostock.api.autostock.mapper;

import autostock.api.autostock.entities.Supplier;
import autostock.api.autostock.models.SupplierModel;

public class SupplierMapper {
    public static Supplier mapToEntity(SupplierModel supplierModel) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierModel.getId());
        supplier.setName(supplierModel.getName());
        supplier.setDescription(supplierModel.getDescription());
        return supplier;
    }
    
}
