package com.example.demo.Service;

import com.example.demo.Model.entities.Product;
import com.example.demo.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Cacheable(value = "product")
    public List<Product> getProduct() {
        return repository.findAll();
    }

    @CacheEvict(value = "product",beforeInvocation = true)
    public String postProduct (Product product) {
        repository.save(product);
        return " Product SuccessFully Added .......! ";
    }

    @CacheEvict(value = "product",beforeInvocation = true)
    public String putProduct(Product product) {
        repository.save(product);
        return " Product SuccessFully Updated .......! ";
    }

    @CacheEvict(value = "product",beforeInvocation = true)
    public String deleteProduct(long id) {
        repository.deleteById(id);
        return " Product Delete SuccessFully .......! ";
    }

    @CacheEvict(value = "product",beforeInvocation = true)
    public String deleteListOfProduct(List<Long> product) {
        for (Long id:product) {
            repository.deleteById(id);
        }
        return " Products Delete SuccessFully .......! ";
    }

    public List<Product> queryProduct(Set<Long> id) {
        return repository.getId(id);
    }

    @CacheEvict(value = "product",beforeInvocation = true)
    public String patchProduct(Product product) {
        Product existProduct = repository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException(" Product Not Found .......! "));
        repository.save(existProduct);
        return " Product Update .....!  ";
    }

}

