package com.example.demo.Repository;

import com.example.demo.Model.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    String RawQuery = "SELECT * FROM cart WHERE id IN :cartId;";
    @Query(nativeQuery = true,value = RawQuery)
    List<Cart> getId (@Param("cartId") Set<Long> cartId);

}

