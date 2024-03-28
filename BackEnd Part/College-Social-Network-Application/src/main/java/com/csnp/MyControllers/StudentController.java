package com.csnp.MyControllers;

import com.csnp.DTOs.ArticleDTO;
import com.csnp.DTOs.EventDTO;
import com.csnp.Enum.Status;
import com.csnp.Models.Article;
import com.csnp.Models.Event;
import com.csnp.Models.Student;
import com.csnp.MyServices.ArticleService;
import com.csnp.MyServices.StudentService;
import com.csnp.DTOs.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private ArticleService articleService;

    @Autowired
    public StudentController(StudentService studentService, ArticleService articleService) {
        this.studentService = studentService;
        this.articleService = articleService;
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        studentService.Register(studentDTO);
        return new ResponseEntity<>("Registration successful", HttpStatus.OK);
    }

    @GetMapping("/login/{mobileNumber}/{password}")
    public ResponseEntity<String> loginStudent(@PathVariable long mobileNumber, @PathVariable String password) {
        studentService.login(mobileNumber, password);
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String username) {
        Optional<Student> student = studentService.getStudentByName(username);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-article/{mobileNumber}/{name}/{content}")
    public String addArticle(@PathVariable long mobileNumber,
                             @PathVariable String name,
                             @PathVariable String content) {
        return studentService.addArticle(mobileNumber, name, content);
    }

    //    @GetMapping("/get-allArticles")
//    public List<Article> getAllArticles(){
//        return studentService.getAllApprovedArticles();
//    }
    @GetMapping("/get-AllArticles")
    public ResponseEntity <List<ArticleDTO>> getAllApprovedArticles() {


        List<Article> articles = articleService.getAllArticles();
        List<ArticleDTO> approvedArticleDTOs = articles.stream()
                .filter(article -> article.getStatus() == Status.APPROVED)
                .map(article -> new ArticleDTO(
                        article.getId(),
                        article.getName(),
                        article.getStatus(),
                        article.getContent(),
                        article.getPersonRole(),
                        article.getPersonName()
                ))
                .collect(Collectors.toList());
        return new ResponseEntity<>(approvedArticleDTOs, HttpStatus.OK);
    }
}
