package com.csnp.MyServices;

import com.csnp.Enum.Status;
import com.csnp.Models.Article;
import com.csnp.Models.Student;

import java.util.List;
import java.util.Optional;

import com.csnp.DTOs.StudentDTO;

public interface StudentService {
    List<Student> getAllStudents();


    void Register(StudentDTO studentDTO);

//    void login(String username, String password);


//    List<Article> getAllApprovedArticles();
    List<Article> findAllByStatus(Status status);
    String addArticle(long mobileNumber, String name, String content);

    Optional<Student> getStudentByName(String username);

    void login(long mobileNumber, String password);



}
