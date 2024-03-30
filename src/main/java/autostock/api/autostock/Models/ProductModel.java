package autostock.api.autostock.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = ProductModel.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel {
    public static final String TABLE_NAME = "produto";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 15, nullable = false, unique = false)
    @Size(min = 3, max = 15, message = "O nome não pode ter mais de 15 caracteres e menos que 3")
    @NotBlank(message = "O Nome é obrigatório e não pode estar vazio")
    private String name;

    
    @Column(name = "valor", length = 5, nullable = false, unique = false)
    @Size(min =1, max = 5, message = "O valor do produto  não pode ter menos de 1 caractere e mais do que 5 caracteres")
    @NotBlank(message = "O valor do produto   não pode está vazio")
    private double value;

    @Column(name = "descricao", length = 30, nullable = false, unique = false)
    @Size(min =5, max = 30, message = "A descrição não pode conter menos de 5 caracteres e não deve ter mais que 30 caracteres")
    @NotBlank(message = "A Descrição do produto não pode está vazio")
    private String description;

    @Column(name = "quantidade", length = 5, nullable = false, unique = false)
    @Size(min =1, max = 5, message = "A Quantidade deve conter pelo menos 1 caractere e até 5 caracteres")
    @NotBlank(message = "Quantidade não pode está vazio")
    private int amount;

    @Column(name = "quantidade_minima", length = 5, nullable = false, unique = false)
    @Size(min =1, max = 5, message = "A Quantidade mínima deve ser ")
    @NotBlank(message = "A Quantidade do produto não pode está vazio")
    private int amountMinimum ;

    @ManyToOne 
    @JoinColumn(name = "produto_fornecedor_id", nullable = false, updatable = false)
    @NotNull(message = "O fornecedor do produto não pode ser nulo")
    private SupplierModel  supplierModel ;
}
