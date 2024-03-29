package autostock.api.autostock.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import autostock.api.autostock.Entities.Product;
import autostock.api.autostock.Mapper.ProductMapper;
import autostock.api.autostock.Models.ProductModel;

public class ProductController {
    

    @PostMapping("/create")
public String createProduct(@RequestBody ProductModel productModel) {
    Product product = ProductMapper.mapToEntity(productModel);
    // Salvar o produto no banco de dados usando um serviço ou repositório
    return "Produto criado com sucesso: " + product.getName();
}

}
