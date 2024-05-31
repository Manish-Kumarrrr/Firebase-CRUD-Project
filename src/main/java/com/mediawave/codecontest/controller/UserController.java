package com.mediawave.codecontest.controller;

import com.mediawave.codecontest.model.User;
import com.mediawave.codecontest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public String test(){
        return "It's working";
    }


    // Create User
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.createUser(user);
    }


    // Get User
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) throws InterruptedException, ExecutionException {
        return userService.getUser(id);
    }


    // Update User
    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.updateUser( user);
    }


    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) throws ExecutionException, InterruptedException {
        return userService.deleteUser(id);
    }

    // Get All User
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() throws ExecutionException, InterruptedException {
        return userService.getAllUser();
    }
}