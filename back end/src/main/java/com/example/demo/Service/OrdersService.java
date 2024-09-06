package com.example.demo.Service;

import com.example.demo.Model.entities.Orders;
import com.example.demo.Repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository repository;

    @Cacheable(value = "orders")
    public List<Orders> getOrders () {
        return repository.findAll();
    }

    @CacheEvict(value = "orders",beforeInvocation = true)
    public String postOrders (Orders orders) {
        repository.save(orders);
        return " Order SuccessFully Added .......! ";
    }

    @CacheEvict(value = "orders",beforeInvocation = true)
    public String putOrders(Orders orders) {
        repository.save(orders);
        return " Order SuccessFully Updated .......! ";
    }

    @CacheEvict(value = "orders",beforeInvocation = true)
    public String deleteOrders(long id) {
        repository.deleteById(id);
        return " Order Delete SuccessFully .......! ";
    }

    @CacheEvict(value = "orders",beforeInvocation = true)
    public String deleteListOfOrders(List<Long> orders) {
        for (Long id:orders) {
            repository.deleteById(id);
        }
        return " Orders Delete SuccessFully .......! ";
    }

    public List<Orders> queryOrders(Set<Long> id) {
        return repository.getId(id);
    }

    @CacheEvict(value = "orders",beforeInvocation = true)
    public String patchOrder(Orders order) {
        Orders existOrders = repository.findById(order.getId())
                .orElseThrow(() -> new RuntimeException(" Orders Not Found .......! "));
        repository.save(existOrders);
        return " Orders Update .....!  ";
    }

}

