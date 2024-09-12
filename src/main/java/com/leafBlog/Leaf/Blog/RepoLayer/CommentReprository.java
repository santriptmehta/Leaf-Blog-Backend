package com.leafBlog.Leaf.Blog.RepoLayer;

import com.leafBlog.Leaf.Blog.Entity.Article;
import com.leafBlog.Leaf.Blog.Entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentReprository extends MongoRepository<Comment, String> {
    List<Comment> findByArticle(Article article);
}
