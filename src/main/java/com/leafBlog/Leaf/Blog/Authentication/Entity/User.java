package com.leafBlog.Leaf.Blog.Authentication.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
    private String email;

}
