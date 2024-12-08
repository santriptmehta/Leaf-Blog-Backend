package com.leafBlog.Leaf.Blog.Authentication.UserRepo;

import com.leafBlog.Leaf.Blog.Authentication.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
