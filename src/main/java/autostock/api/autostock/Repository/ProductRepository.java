package autostock.api.autostock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import autostock.api.autostock.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
