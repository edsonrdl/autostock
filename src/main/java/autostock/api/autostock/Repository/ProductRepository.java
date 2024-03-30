package autostock.api.autostock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import autostock.api.autostock.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findBySupplierId(Long supplierId);
    
}
