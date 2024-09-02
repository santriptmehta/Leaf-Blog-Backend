package com.leafBlog.Leaf.Blog.RepoLayer;

import com.leafBlog.Leaf.Blog.Entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}
