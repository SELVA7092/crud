package com.example.demo.Controller;

import com.example.demo.Model.entities.Address;
import com.example.demo.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AddressController {

    private final AddressService service;

    @GetMapping("/get/address")
    public List<Address> getApi () {
        return service.getAddress();
    }

    @PostMapping("/post/address")
    public String postApi (@Valid @RequestBody Address address){
        return service.postAddress(address);
    }

    @PutMapping("/put/address/{id}")
    public String PutApi (@Valid @RequestBody Address address, @PathVariable long id) {
        address.setId(id);
        return service.putAddress(address);
    }

    @DeleteMapping("/delete/address/{id}")
    public String deleteApi (@Valid @PathVariable long id) {
        return service.deleteAddress(id);
    }

    @DeleteMapping("/delete/ListOfAddress")
    public String deleteListApi (@Valid @RequestBody List<Long> Address){
        return service.deleteListOfAddress(Address);
    }

    @GetMapping("/getQuery/address/{id}")
    public List<Address> queryGetApi (@Valid @PathVariable Set<Long> id){
        return service.queryAddress(id);
    }

    @PatchMapping("/patch/address/{id}")
    public String patchApi (@Valid @RequestBody Address address, @PathVariable long id) {
        address.setId(id);
        return service.patchAddress(address);
    }

}

