package com.stackroute.neo4jdemo.controller;

import com.stackroute.neo4jdemo.domain.User;
import com.stackroute.neo4jdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public Collection<User> getAll() {

        return userService.getAll();
    }

    @PostMapping("save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("update/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Long id){
        return userService.updateUser(user,id);
    }

    @GetMapping("{name}")
    public  User getUser(@PathVariable String name){
       return userService.getByName(name);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted User";
    }

    @PostMapping("graph/{userId}/{movieId}")
    public User saveRelation(@PathVariable Long userId,@PathVariable Long movieId){
        return userService.saveRelation(userId,movieId);
    }

}