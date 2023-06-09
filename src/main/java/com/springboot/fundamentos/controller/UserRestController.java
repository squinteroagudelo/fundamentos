package com.springboot.fundamentos.controller;

import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.repository.IUserRepository;
import com.springboot.fundamentos.usecase.CreateUser;
import com.springboot.fundamentos.usecase.DeleteUser;
import com.springboot.fundamentos.usecase.IGetUser;
import com.springboot.fundamentos.usecase.UpdateUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private IGetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private IUserRepository userRepository;

    public UserRestController(IGetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, IUserRepository userRepository) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> get() {
        return getUser.getAll();
    }

    @PostMapping()
    ResponseEntity<User> newUser(@RequestBody User user) {
        return new ResponseEntity<>(createUser.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> modifyUser(@RequestBody User user, @PathVariable Long id) {
        return new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK);
    }

    @GetMapping("/paging")
    List<User> getUsersPaging(@RequestParam int page, @RequestParam int size){
        return getUser.getAllPaging(page, size);
    }
}
