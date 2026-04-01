package InventoryManagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling 
{
    @ExceptionHandler(value = InsufficientStockException.class)
    public ResponseEntity<String> handleStock(InsufficientStockException exception) 
    {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}