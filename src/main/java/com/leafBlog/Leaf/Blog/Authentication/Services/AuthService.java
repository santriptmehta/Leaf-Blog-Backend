package com.leafBlog.Leaf.Blog.Authentication.Services;

import com.leafBlog.Leaf.Blog.Authentication.Entity.User;
import com.leafBlog.Leaf.Blog.Authentication.UserRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User newUserRegister(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User authenticateUser(String username, String password){
        User user = userRepository.findByUsername(username);

        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            return user;
        }
        throw new RuntimeException("Invalid User");
    }

}
