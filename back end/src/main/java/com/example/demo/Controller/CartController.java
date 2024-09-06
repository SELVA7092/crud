package com.example.demo.Controller;

import com.example.demo.Model.entities.Cart;
import com.example.demo.Service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CartController {

    private final CartService service;

    @GetMapping("/get/cart")
    public List<Cart> getApi () {
        return service.getCart();
    }

    @PostMapping("/post/cart")
    public String postApi(@Valid @RequestBody Cart cart){
        return service.postCart(cart);
    }

    @PutMapping("/put/cart/{id}")
    public String putApi(@Valid @RequestBody Cart cart, @PathVariable long id){
        cart.setId(id);
        return service.putCart(cart);
    }

    @DeleteMapping("/delete/cart/{id}")
    public String deleteApi (@Valid @PathVariable long id) {
        return service.deleteCart(id);
    }

    @DeleteMapping("/delete/ListOfCart")
    public String deleteListApi (@Valid @RequestBody List<Long> Cart){
        return service.deleteListOfCart(Cart);
    }

    @GetMapping("/getQuery/cart/{id}")
    public List<Cart> queryGetApi (@Valid @PathVariable Set<Long> id){
        return service.queryCart(id);
    }

    @PatchMapping("/patch/cart/{id}")
    public String patchApi ( @Valid @RequestBody Cart cart, @PathVariable long id) {
        cart.setId(id);
        return service.patchCart(cart);
    }

}

