package com.fundamentos.sprinboot.fundamentos.controller;

import com.fundamentos.sprinboot.fundamentos.caseuse.CreateUser;
import com.fundamentos.sprinboot.fundamentos.caseuse.DeleteUser;
import com.fundamentos.sprinboot.fundamentos.caseuse.GetUser;
import com.fundamentos.sprinboot.fundamentos.caseuse.UpdateUser;
import com.fundamentos.sprinboot.fundamentos.entitys.User;
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

    public UserController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser,
                          UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser=createUser;
        this.deleteUser=deleteUser;
        this.updateUser=updateUser;

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
}
