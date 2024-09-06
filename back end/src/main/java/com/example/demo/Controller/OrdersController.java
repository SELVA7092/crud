package com.example.demo.Controller;

import com.example.demo.Model.entities.Orders;
import com.example.demo.Service.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class OrdersController {

    private final OrdersService service;

    @GetMapping("/get/orders")
    public List<Orders> getApi () {
        return service.getOrders();
    }

    @PostMapping("/post/orders")
    public String postApi(@Valid @RequestBody Orders orders){
        return service.postOrders(orders);
    }

    @PutMapping("/put/orders/{id}")
    public String putApi(@Valid @RequestBody Orders order, @PathVariable long id){
        order.setId(id);
        return service.putOrders(order);
    }

    @DeleteMapping("/delete/orders/{id}")
    public String deleteApi (@Valid @PathVariable long id) {
        return service.deleteOrders(id);
    }

    @DeleteMapping("/delete/ListOfOrders")
    public String deleteListApi (@Valid @RequestBody List<Long> Orders){
        return service.deleteListOfOrders(Orders);
    }

    @GetMapping("/getQuery/orders/{id}")
    public List<Orders> queryGetApi (@Valid @PathVariable Set<Long> id){
        return service.queryOrders(id);
    }

    @PatchMapping("/patch/orders/{id}")
    public String patchApi (@Valid @RequestBody Orders order, @PathVariable long id) {
        order.setId(id);
        return service.patchOrder(order);
    }

}

