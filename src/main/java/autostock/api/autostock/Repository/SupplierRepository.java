package autostock.api.autostock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import autostock.api.autostock.Entities.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    
}
