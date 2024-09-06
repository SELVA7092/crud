package com.example.demo.Repository;

import com.example.demo.Model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    String RawQuery = "SELECT * FROM address WHERE id IN :addressId";
    @Query(nativeQuery = true,value = RawQuery)
    List<Address> getId (@Param("addressId") Set<Long> addressId);

}

