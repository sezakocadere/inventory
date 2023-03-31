package com.example.inventory.service.aspect;

import com.example.inventory.enums.Operation;
import com.example.inventory.service.history.HistoryService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class Logging {
    private final HistoryService historyService;

    @Pointcut("execution(* com.example.inventory.service.product.ProductServiceImpl.createProduct(..)) || execution(* com.example.inventory.service.stock.StockServiceImpl.createStock(..)) || execution(* com.example.inventory.service.category.CategoryServiceImpl.createCategory(..)) || execution(* com.example.inventory.service.warehouse.WarehouseServiceImpl.createWarehouse(..))")
    private void saveCreateData() {
    }

    @Pointcut("execution(* com.example.inventory.service.product.ProductServiceImpl.updateProduct(..))")
    private void saveUpdateData() {
    }

    @Pointcut("execution(* com.example.inventory.service.product.ProductServiceImpl.removeProduct(..))")
    private void saveDeleteData() {
    }

    @Pointcut("execution(* com.example.inventory.service.product.ProductServiceImpl.reductionProduct(..))")
    private void saveReductionData() {
    }

    @AfterReturning(pointcut = "saveCreateData()", returning = "result")
    public void create(JoinPoint joinPoint, Object result) {
        historyService.save(Operation.CREATE, result.toString());
    }

    @AfterReturning(pointcut = "saveUpdateData()", returning = "result")
    public void update(JoinPoint joinPoint, Object result) {
        historyService.save(Operation.UPDATE, result.toString());
    }

    @AfterReturning(pointcut = "saveDeleteData()", returning = "result")
    public void delete(JoinPoint joinPoint, Object result) {
        historyService.save(Operation.DELETE, result.toString());
    }

    @AfterReturning(pointcut = "saveReductionData()", returning = "result")
    public void reduction(JoinPoint joinPoint, Object result) {
        historyService.save(Operation.REDUCTION, result.toString());
    }
}
