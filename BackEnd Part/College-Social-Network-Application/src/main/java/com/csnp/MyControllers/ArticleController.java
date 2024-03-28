package com.csnp.MyControllers;

import com.csnp.Enum.Status;
import com.csnp.Exception.ArticleException;
import com.csnp.Models.Article;
import com.csnp.Models.PlacementOfficer;
import com.csnp.Models.Student;
import com.csnp.MyServices.ArticleService;
import com.csnp.MyServices.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/articles")
public class ArticleController {
    
    private  ArticleService articleService;
    
    private  StudentService studentService;

    @Autowired
    public ArticleController(ArticleService articleService, StudentService studentService) {
        this.articleService = articleService;
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> AddArticleForApproval(@RequestBody Student student,@RequestBody Article article,@RequestBody Status status,@RequestBody PlacementOfficer placementOfficer) throws ArticleException {
        String response = articleService.AddArticleForApproval(student ,article, status,placementOfficer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) throws ArticleException {
        Article article = articleService.getArticleById(id);
        return ResponseEntity.ok().body(article);
    }
    @GetMapping("/name/{title}")
    public ResponseEntity<Article> getArticleByName(@PathVariable("title") String title) throws ArticleException {
        Article article = articleService.getArticleByName(title);
        return ResponseEntity.ok().body(article);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) throws ArticleException {
        Article response = articleService.updateArticle(article);
        return ResponseEntity.ok().body(response);
    }

    //    @PostMapping
//    public ResponseEntity<String> addArticleForApproval(@RequestBody Article article) {
//        articleService.addArticleForApproval(article);
//        return ResponseEntity.ok("Article added for approval.");
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok().body("Article deleted successfully");
    }


//    @PostMapping
//    public ResponseEntity<String> addArticleForApproval(@RequestBody Article article) {
//        articleService.addArticleForApproval(article);
//        return ResponseEntity.ok("Article added for approval.");
//    }
}

