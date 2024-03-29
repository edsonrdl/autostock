package autostock.api.autostock.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private Long id;

    private String name;

    private double price;

    private String description;

    private int amount;

    private int amountMinimum ;

    private Supplier supplier;
}
