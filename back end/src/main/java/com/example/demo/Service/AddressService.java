package com.example.demo.Service;

import com.example.demo.Model.entities.Address;
import com.example.demo.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    @Cacheable(value = "address")
    public List<Address> getAddress () {
        return repository.findAll();
    }

    @CacheEvict(value = "address",beforeInvocation = true)
    public String postAddress (Address address) {
        repository.save(address);
        return " Address SuccessFully Added .......! ";
    }

    @CacheEvict(value = "address",beforeInvocation = true)
    public String putAddress(Address address) {
        repository.save(address);
        return " Address SuccessFully Updated .......! ";
    }

    @CacheEvict(value = "address",beforeInvocation = true)
    public String deleteAddress(long id) {
        repository.deleteById(id);
        return " Address Delete SuccessFully .......! ";
    }

    @CacheEvict(value = "address",beforeInvocation = true)
    public String deleteListOfAddress(List<Long> address) {
        for (Long id:address) {
            repository.deleteById(id);
        }
        return " Addresses Delete SuccessFully .......! ";
    }

    public List<Address> queryAddress(Set<Long> id) {
        return repository.getId(id);
    }

    @CacheEvict(value = "address",beforeInvocation = true)
    public String patchAddress(Address address) {
            Address existAddress = repository.findById(address.getId())
                    .orElseThrow(() -> new RuntimeException(" Address Not Found .......! "));
            repository.save(existAddress);
            return " Student Update .....!  ";
    }

}

