package com.leafBlog.Leaf.Blog.RepoLayer;

import com.leafBlog.Leaf.Blog.Entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {

    List<Article> findByTitleContaining(String title);
    List<Article> findByAuthor(String author);
    List<Article> findByTitleContainingAndAuthor(String search, String author);
}
