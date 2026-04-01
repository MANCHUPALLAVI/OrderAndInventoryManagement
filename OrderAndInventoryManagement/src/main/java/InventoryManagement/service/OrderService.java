package InventoryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import InventoryManagement.entity.OrderItems;
import InventoryManagement.entity.Orders;
import InventoryManagement.entity.Product;
import InventoryManagement.exception.InsufficientStockException;
import InventoryManagement.repository.OrdersRepository;
import InventoryManagement.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public Orders placeorder(int id, int qty) 
    {
        //Step 1: Get product
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product unavailable"));

        //Step 2: Check stock
        if (product.getStock() < qty) {
            throw new InsufficientStockException("Insufficient stock");
        }

        //Step 3: Reduce stock
        product.setStock(product.getStock() - qty);

        // Step 4: Create Order
        Orders orders = new Orders();
        orders.setDateTime(LocalDateTime.now());

        //Step 5: Create OrderItem
        OrderItems item = new OrderItems();
        item.setProduct(product);
        item.setQty(qty);
        item.setOrders(orders);

        // Step 6: Set items into order
        orders.setItems(List.of(item));

        //Step 7: Save order
        return ordersRepository.save(orders);
    }
}