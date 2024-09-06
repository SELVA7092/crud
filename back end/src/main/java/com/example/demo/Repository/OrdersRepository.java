package com.example.demo.Repository;

import com.example.demo.Model.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    String RawQuery = "SELECT * FROM orders WHERE id IN :orderId";
    @Query(nativeQuery = true,value = RawQuery)
    List<Orders> getId (@Param("orderId") Set<Long> orderId);

}

