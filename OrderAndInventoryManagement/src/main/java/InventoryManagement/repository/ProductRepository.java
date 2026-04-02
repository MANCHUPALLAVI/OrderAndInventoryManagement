package InventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import InventoryManagement.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
    // Custom methods (optional)
    Product findByName(String name);
}
