package com.example.demo.Service;


import com.example.demo.Model.entities.Cart;
import com.example.demo.Repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository repository;

    @Cacheable(value = "cart")
    public List<Cart> getCart () {
        return repository.findAll();
    }

    @CacheEvict(value = "cart",beforeInvocation = true)
    public String postCart (Cart cart) {
        repository.save(cart);
        return " Cart SuccessFully Added .......! ";
    }

    @CacheEvict(value = "cart",beforeInvocation = true)
    public String putCart(Cart cart) {
        repository.save(cart);
        return " Cart SuccessFully Updated .......! ";
    }

    @CacheEvict(value = "cart",beforeInvocation = true)
    public String deleteCart(long id) {
        repository.deleteById(id);
        return " Cart Delete SuccessFully .......! ";
    }

    @CacheEvict(value = "cart",beforeInvocation = true)
    public String deleteListOfCart(List<Long> cart) {
        for (Long id:cart) {
            repository.deleteById(id);
        }
        return " Carts Delete SuccessFully .......! ";
    }

    public List<Cart> queryCart(Set<Long> id) {
        return repository.getId(id);
    }

    @CacheEvict(value = "cart",beforeInvocation = true)
    public String patchCart(Cart cart) {
        Cart existCart = repository.findById(cart.getId())
                .orElseThrow(() -> new RuntimeException(" Cart Not Found .......! "));
        repository.save(existCart);
        return " Cart Update .....!  ";
    }

}

