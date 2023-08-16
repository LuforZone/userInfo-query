package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.demo.entity.Result;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}") // get user by email
    public ResponseEntity<Result<User>> getUser(@PathVariable String email) {
        User queryResult = userService.getUserByEmail(email);
        System.out.println( "getMapping" + queryResult);
        if (queryResult != null) {
            Result<User> result = new Result<User>(200, "success", queryResult);
            return ResponseEntity.ok(result);
        } else {
            Result<User> result = new Result<>(HttpStatus.NOT_FOUND.value(), "User not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @PostMapping // add users
    public ResponseEntity<Result<User>> addUser(@RequestBody User user) {
        System.out.println("have access postMapping");
        User queryResult = userService.getUserByEmail(user.getEmail());
        System.out.println("is there has account " + queryResult);
        if (queryResult != null) {
            System.out.println("User already exists");
            Result<User> result = new Result<>(HttpStatus.CONFLICT.value(), "User already exists", null);
            result.setMessage("User already exists");
            System.out.println(result.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
            
        } else {
            userService.addUser(user);
            System.out.println("User added");
            Result<User> result = new Result<>(200, "success", null);
            return ResponseEntity.ok(result);
        }
    }

    @PutMapping("/{email}") // update users
    ResponseEntity<Result<User>> updateUser(@PathVariable String email, @RequestBody User user) {
        User queryResult = userService.getUserByEmail(email);
        System.out.println("have access putMapping");
        System.out.println("is there has account " + queryResult);
        if (queryResult != null) {
            userService.updateUserByEmail(email, user);
            Result<User> result = new Result<>(200, "success", null);
            return ResponseEntity.ok(result);
        } else {
            Result<User> result = new Result<>(HttpStatus.NOT_FOUND.value(), "User not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @DeleteMapping("/{email}") // delete users
    public ResponseEntity<Result<User>> deleteUser(@PathVariable String email) {
        User queryResult = userService.getUserByEmail(email);
        System.out.println("have access deleteMapping");
        if (queryResult != null) {
            userService.deleteUserByEmail(email);
            Result<User> result = new Result<>(200, "success", null);
            return ResponseEntity.ok(result);
        } else {
            Result<User> result = new Result<>(HttpStatus.NOT_FOUND.value(), "User not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

}
