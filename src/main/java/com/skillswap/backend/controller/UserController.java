//package com.skillswap.backend.controller;
//
//public class UserController {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

package com.skillswap.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillswap.backend.entity.User;
import com.skillswap.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Save User
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    // Get User By ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    // Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    
    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
    
 // Login User
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        return userService.loginUser(user.getEmail(), user.getPassword());

    }
}
