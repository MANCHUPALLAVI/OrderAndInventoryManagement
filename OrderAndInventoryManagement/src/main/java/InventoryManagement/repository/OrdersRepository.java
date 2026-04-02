package InventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import InventoryManagement.entity.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> 
{

}
