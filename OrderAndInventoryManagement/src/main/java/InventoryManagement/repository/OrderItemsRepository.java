package InventoryManagement.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import InventoryManagement.entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>
{
    List<OrderItems> findByOrdersId(Integer orderId);

}