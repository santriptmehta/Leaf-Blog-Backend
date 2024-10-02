package com.leafBlog.Leaf.Blog.Services;

import com.leafBlog.Leaf.Blog.Entity.Article;
import com.leafBlog.Leaf.Blog.RepoLayer.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(String id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(String id, Article articleDetails) {
        return articleRepository.findById(id)
                .map(article -> {
                    article.setTitle(articleDetails.getTitle());
                    article.setContent(articleDetails.getContent());
                    article.setUpdatedAt(articleDetails.getUpdatedAt());
                    return articleRepository.save(article);
                })
                .orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    public void deleteArticle(String id) {
        articleRepository.deleteById(id);
    }

    public List<Article>getArticles(String search, String author){
        if(search != null && author != null){
            return articleRepository.findByTitleContainingAndAuthor(search, author);
        } else if (search != null) {
            return articleRepository.findByTitleContaining(search);
        }else if (author != null){
            return articleRepository.findByAuthor(author);
        }else{
            return articleRepository.findAll();
        }
    }
}
