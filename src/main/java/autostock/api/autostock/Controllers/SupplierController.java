package autostock.api.autostock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autostock.api.autostock.entities.Supplier;
import autostock.api.autostock.mapper.SupplierMapper;
import autostock.api.autostock.models.SupplierModel;
import autostock.api.autostock.useCases.supplier.CreateSupplier.ICreateSupplierUseCase;
import autostock.api.autostock.useCases.supplier.DeleteSupplier.IDeleteSupplierUseCase;
import autostock.api.autostock.useCases.supplier.GetAllSupplier.IGetAllSupplierUseCase;
import autostock.api.autostock.useCases.supplier.GetSupplier.IGetSupplierUseCase;
import autostock.api.autostock.useCases.supplier.UpdateSupplier.IUpdateSupplierUseCase;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    
    
    @Autowired
    private ICreateSupplierUseCase  _ICreateSupplierUseCase ;

    @Autowired
    private IGetSupplierUseCase  _IGetSupplierUseCase ;
    
    @Autowired
    private IGetAllSupplierUseCase  _IGetAllSupplierUseCase ;

    @Autowired
    private IUpdateSupplierUseCase  _IUpdateSupplierUseCase ;

    @Autowired
    private IDeleteSupplierUseCase  _IDeleteSupplierUseCase ;


    @PostMapping
    public ResponseEntity<Object> createSupplier(@RequestBody SupplierModel SupplierModel) {
        Supplier Supplier = SupplierMapper.mapToEntity(SupplierModel);
        _ICreateSupplierUseCase.createSupplier(Supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(Supplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSupplierById(@PathVariable Long id) {
     try {
            Supplier Supplier = _IGetSupplierUseCase.getSupplier(id);
            return ResponseEntity.ok(Supplier);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> Suppliers = _IGetAllSupplierUseCase.getAllSupplier();
        return ResponseEntity.ok(Suppliers);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSupplier(@PathVariable Long id, @RequestBody SupplierModel SupplierModel) {
        Supplier Supplier = SupplierMapper.mapToEntity(SupplierModel);
        Supplier.setId(id);
        return ResponseEntity.ok( _IUpdateSupplierUseCase.updateSupplier(Supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        _IDeleteSupplierUseCase.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
