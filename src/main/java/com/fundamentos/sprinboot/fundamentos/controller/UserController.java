package com.fundamentos.sprinboot.fundamentos.controller;

import com.fundamentos.sprinboot.fundamentos.caseuse.*;
import com.fundamentos.sprinboot.fundamentos.entitys.User;
import com.fundamentos.sprinboot.fundamentos.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private UserRepository userRepository;
    private PageableUser pageableUser;


    public UserController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser,
                          UpdateUser updateUser,PageableUser pageableUser,UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser=createUser;
        this.deleteUser=deleteUser;
        this.updateUser=updateUser;
        this.userRepository=userRepository;
        this.pageableUser=pageableUser;


    }

    @GetMapping("/")
    public List<User> getAll(){
        return getUser.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(createUser.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity userDelete(@PathVariable long id){
        deleteUser.remove(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser,@PathVariable long id){
        return new ResponseEntity<>(updateUser.update(newUser,id),HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public List<User> getUsersAll(@RequestParam int page,@RequestParam int size){
        return userRepository.findAll(PageRequest.of(page,size)).getContent();
    }
}
