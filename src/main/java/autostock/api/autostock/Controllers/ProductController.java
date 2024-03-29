package autostock.api.autostock.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autostock.api.autostock.Entities.Product;
import autostock.api.autostock.Mapper.ProductMapper;
import autostock.api.autostock.Models.ProductModel;
import autostock.api.autostock.UseCases.CreateProduct.CreateProductUseCaseImpl;
import autostock.api.autostock.UseCases.CreateProduct.ICreateProductUseCase;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ICreateProductUseCase  _ICreateProductUseCase ;

    public ProductController(CreateProductUseCaseImpl createProductUseCase) {
        _ICreateProductUseCase = createProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductModel productModel) {
        Product product = ProductMapper.mapToEntity(productModel);
        _ICreateProductUseCase.execute(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    
  

}
