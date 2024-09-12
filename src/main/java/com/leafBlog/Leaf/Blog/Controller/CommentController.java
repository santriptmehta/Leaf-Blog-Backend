package com.leafBlog.Leaf.Blog.Controller;

import com.leafBlog.Leaf.Blog.Entity.Comment;
import com.leafBlog.Leaf.Blog.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<Comment>createComment(@PathVariable String articleId, @RequestBody Comment comment){
        Comment createdComment = commentService.createComment(articleId, comment);
        return ResponseEntity.ok(createdComment);
    }
    @GetMapping
    public List<Comment> getCommentByArticleId(@PathVariable String articleId){
        return commentService.getCommentByArticleId(articleId);
    }
}
