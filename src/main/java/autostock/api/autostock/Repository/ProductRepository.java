package autostock.api.autostock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import autostock.api.autostock.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
