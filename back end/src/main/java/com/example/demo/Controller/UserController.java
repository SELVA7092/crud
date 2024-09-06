package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserService service;

    @GetMapping("/get/user")
    public List<User> getApi () {
        return service.getUser();
    }

    @PostMapping("/post/user")
    public String postApi(@Valid @RequestBody User user){
        return service.postUser(user);
    }

    @PutMapping("/put/user/{id}")
    public String putApi (@Valid @RequestBody User user, @PathVariable long id){
        user.setId(id);
        return service.putUser(user);
    }

    @DeleteMapping("/delete/user/{id}")
    public String deleteApi (@Valid @PathVariable long id) {
        return service.deleteUser(id);
    }

    @DeleteMapping("/delete/ListOfUser")
    public String deleteListApi (@Valid @RequestBody List<Long> user){
        return service.deleteListOfUser(user);
    }

    @GetMapping("/getQuery/user/{id}")
    public List<User> queryApi (@Valid @PathVariable Set<Long> id){
        return service.queryUser(id);
    }

    @PatchMapping("/patch/user/{id}")
    public String patchApi ( @Valid @RequestBody User user, @PathVariable long id) {
        user.setId(id);
        return service.patchUser(user);
    }

}

