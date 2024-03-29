package autostock.api.autostock.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import autostock.api.autostock.entities.Supplier;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductModel {

     @Column(name = "name", length = 15, nullable = false, unique = false)
    @Size(min = 3, max = 15, message = "O nome não pode ter mais de 15 caracteres e menos que 3")
    @NotBlank(message = "O Nome é obrigatório e não pode estar vazio")
    private String name;

    
    @Column(name = "price", length = 5, nullable = false, unique = false)
    @Size(min =1, max = 5, message = "O valor do produto  não pode ter menos de 1 caractere e mais do que 5 caracteres")
    @NotBlank(message = "O valor do produto   não pode está vazio")
    private double price;

    @Column(name = "description", length = 30, nullable = false, unique = false)
    @Size(min =5, max = 30, message = "A descrição não pode conter menos de 5 caracteres e não deve ter mais que 30 caracteres")
    @NotBlank(message = "A Descrição do produto não pode está vazio")
    private String description;

    @Column(name = "amount", length = 5, nullable = false, unique = false)
    @Size(min =1, max = 5, message = "A Quantidade deve conter pelo menos 1 caractere e até 5 caracteres")
    @NotBlank(message = "Quantidade não pode está vazio")
    private int amount;

    @Column(name = "amount_minimum", length = 5, nullable = false, unique = false)
    @Size(min =1, max = 5, message = "A Quantidade mínima deve ser ")
    @NotBlank(message = "A Quantidade do produto não pode está vazio")
    private int amountMinimum ;

    @ManyToOne 
    @JoinColumn(name = "product_supplier_id", nullable = false, updatable = false)
    private Supplier supplier;

}
