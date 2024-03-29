package autostock.api.autostock.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

      //    @GetMapping("/{id}")
    // public ResponseEntity<CategoryMenu> getCategoryMenuById(@PathVariable Long id) {
    //     CategoryMenu categoryMenu = categoryMenuService.findById(id);
    //     return ResponseEntity.ok(categoryMenu);
    // }

    // @GetMapping("/categories")
    // public ResponseEntity<List<CategoryMenu>> getAllItemMenus() {
    //     List<CategoryMenu> categoriesMenu = categoryMenuService.findAllCategoriesMenu();
    //     return ResponseEntity.ok(categoriesMenu);
    // }

    // @PostMapping
    // public ResponseEntity<CategoryMenu> createCategoryMenu(@RequestBody CategoryMenu categoryMenu) {
    //     System.out.println("webhook - received");
    //     CategoryMenu createdCategoryMenu = categoryMenuService.create(categoryMenu);
    //     return new ResponseEntity<>(createdCategoryMenu, HttpStatus.CREATED);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<CategoryMenu> updateCategoryMenu(@PathVariable Long id, @RequestBody CategoryMenu categoryMenu) {
    //     categoryMenu.setId(id);
    //     CategoryMenu updatedCategoryMenu = categoryMenuService.update(categoryMenu);
    //     return ResponseEntity.ok(updatedCategoryMenu);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteCategoryMenu(@PathVariable Long id) {
    //     categoryMenuService.delete(id);
    //     return ResponseEntity.noContent().build();
    // }

    // @GetMapping("/{id}/type-items")
    // public ResponseEntity<List<TypeItem>> listCategoriesByMenuId(@PathVariable Long id) {
    //     List<TypeItem> typeItems = categoryMenuService.listTypeItemsByCategoryMenuId(id);
    //     return ResponseEntity.ok(typeItems);
    // }
    
  

}
