package autostock.api.autostock.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = SupplierModel.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierModel {
    public static final String TABLE_NAME = "supplier";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 15, nullable = false, unique = false)
    @Size(min = 3, max = 15, message = "O nome do fornecedor não pode ter mais de 15 caracteres e menos que 3")
    @NotBlank(message = "O Nome do fornecedor é obrigatório e não pode estar vazio")
    private String name;

    @Column(name = "description", length = 30, nullable = false, unique = false)
    @Size(min = 5, max = 30, message = "A descrição do fornecedor não pode conter menos de 5 caracteres e não deve ter mais que 30 caracteres")
    @NotBlank(message = "A Descrição do fornecedor não pode está vazio")
    private String description;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "supplierModel", cascade = CascadeType.ALL)
    private List<ProductModel> product = new ArrayList<ProductModel>();
}
