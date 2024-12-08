package com.leafBlog.Leaf.Blog.Authentication.Controller;

import com.leafBlog.Leaf.Blog.Authentication.Entity.User;
import com.leafBlog.Leaf.Blog.Authentication.JwtUtil;
import com.leafBlog.Leaf.Blog.Authentication.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signUp")
    public String addUser(@RequestBody User user){
        authService.newUserRegister(user);
        return "User Register Successfully";
    }
    @PostMapping("/login")
    public String signIn(@RequestBody User user){
        User existingUser = authService.authenticateUser(user.getUsername(), user.getPassword());
        return jwtUtil.generateToken(existingUser.getUsername());
    }
}
