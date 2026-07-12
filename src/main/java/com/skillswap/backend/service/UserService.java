//package com.skillswap.backend.service;
//
//public class UserService {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

package com.skillswap.backend.service;

import com.skillswap.backend.security.JwtUtil;
import com.skillswap.backend.dto.LoginResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillswap.backend.entity.User;
import com.skillswap.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

//    // Save user
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
    
 // Save user
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    // Update User
    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());

            return userRepository.save(user);
        }

        return null;
    }
    
    // Delete User
    public String deleteUser(Long id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully!";
        }

        return "User not found!";
    }
    
 // Login User
//    public String loginUser(String email, String password) {
//
//        User user = userRepository.findByEmail(email);
//
//        if (user != null && user.getPassword().equals(password)) {
//            return "Login Successful";
//        }
//
//        return "Invalid Email or Password";
//    }
    
    public String loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return "Login Successful";
        	String token = jwtUtil.generateToken(user.getEmail());
        	return token;
        }

        return "Invalid Email or Password";
    }
}