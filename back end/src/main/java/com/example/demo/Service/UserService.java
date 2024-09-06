package com.example.demo.Service;

import com.example.demo.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.UserRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Cacheable(value = "user")
    public List<User> getUser () {
        return repository.findAll();
    }

    @CacheEvict(value = "user",beforeInvocation = true)
    public String postUser (User user) {
        repository.save(user);
        return " User SuccessFully Register .......! ";
    }

    @CacheEvict(value = "user",beforeInvocation = true)
    public String putUser (User user) {
        repository.save(user);
        return " User SuccessFully Updated .......! ";
    }

    @CacheEvict(value = "user",beforeInvocation = true)
    public String deleteUser (long id) {
        repository.deleteById(id);
        return " User Delete SuccessFully .......! ";
    }

    @CacheEvict(value = "user",beforeInvocation = true)
    public String deleteListOfUser (List<Long> user) {
        for (Long id:user) {
            repository.deleteById(id);
        }
        return " Users Delete SuccessFully .......! ";
    }

    public List<User> queryUser (Set<Long> id) {
        return repository.getId(id);
    }

    @CacheEvict(value = "user",beforeInvocation = true)
    public String patchUser(User user) {
        User existUser = repository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException(" User Not Found .......! "));
        repository.save(existUser);
        return " User Update .....!  ";
    }

}

