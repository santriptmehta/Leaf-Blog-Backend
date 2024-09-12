package com.leafBlog.Leaf.Blog.Services;

import com.leafBlog.Leaf.Blog.Entity.Article;
import com.leafBlog.Leaf.Blog.Entity.Comment;
import com.leafBlog.Leaf.Blog.RepoLayer.CommentReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentReprository commentReprository;
    private final ArticleService articleService;

    @Autowired
    public CommentService(CommentReprository commentReprository, ArticleService articleService) {
        this.commentReprository = commentReprository;
        this.articleService = articleService;
    }
    public Comment createComment(String articleId, Comment comment){
        Article article = articleService.getArticleById(articleId).orElseThrow(() -> new IllegalArgumentException("Article Not Found"));
        comment.setArticle(article);
        return commentReprository.save(comment);
    }
    public List<Comment> getCommentByArticleId(String articleId){
        Article article = articleService.getArticleById(articleId).orElseThrow(()-> new IllegalArgumentException("Article Not Found"));
        return commentReprository.findByArticle(article);
    }
}
