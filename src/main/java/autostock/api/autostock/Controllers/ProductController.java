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

import autostock.api.autostock.entities.Product;
import autostock.api.autostock.mapper.ProductMapper;
import autostock.api.autostock.models.ProductModel;
import autostock.api.autostock.useCases.product.CreateProduct.ICreateProductUseCase;
import autostock.api.autostock.useCases.product.DeleteProduct.IDeleteProductUseCase;
import autostock.api.autostock.useCases.product.GetAllProduct.IGetAllProductUseCase;
import autostock.api.autostock.useCases.product.GetProduct.IGetProductUseCase;
import autostock.api.autostock.useCases.product.UpdateProduct.IUpdateProductUseCase;
import jakarta.persistence.EntityNotFoundException;
import autostock.api.autostock.useCases.product.CreateProduct.CreateProductUseCaseImpl;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ICreateProductUseCase  _ICreateProductUseCase ;

    @Autowired
    private IGetProductUseCase  _IGetProductUseCase ;
    @Autowired
    private IGetAllProductUseCase  _IGetAllProductUseCase ;

    @Autowired
    private IUpdateProductUseCase  _IUpdateProductUseCase ;

    @Autowired
    private IDeleteProductUseCase  _IDeleteProductUseCase ;


    public ProductController(CreateProductUseCaseImpl createProductUseCase) {
        _ICreateProductUseCase = createProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductModel productModel) {
        Product product = ProductMapper.mapToEntity(productModel);
        _ICreateProductUseCase.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
     try {
            Product product = _IGetProductUseCase.getProduct(id);
            return ResponseEntity.ok(product);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = _IGetAllProductUseCase.getAllProduct();
        return ResponseEntity.ok(products);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel) {
        Product product = ProductMapper.mapToEntity(productModel);
        product.setId(id);
        return ResponseEntity.ok( _IUpdateProductUseCase.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        _IDeleteProductUseCase.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
