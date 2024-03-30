package autostock.api.autostock.entities;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double value;

    private String description;

    private int amount;

    private int amountMinimum ;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @JsonIgnore
    @NotNull(message = "O fornecedor do produto não pode ser nulo")
    private Supplier supplier;
}
