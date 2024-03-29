package autostock.api.autostock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import autostock.api.autostock.entities.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    
}
