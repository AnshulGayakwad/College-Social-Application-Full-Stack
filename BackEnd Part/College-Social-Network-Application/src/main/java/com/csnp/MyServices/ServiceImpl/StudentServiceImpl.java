package com.csnp.MyServices.ServiceImpl;

import com.csnp.Enum.Status;
import com.csnp.Models.Article;
import com.csnp.Models.Student;
import com.csnp.MyRepositories.*;
import com.csnp.MyServices.StudentService;
import com.csnp.DTOs.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
	
    private final StudentRepository studentRepository;
	
    private final ArticleRepository articleRepository;
	
    private final ChatRepository chatRepository;
	
    private final AdminRepository adminRepository;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ArticleRepository articleRepository, ChatRepository chatRepository,  AdminRepository adminRepository) {
        super();
        this.studentRepository = studentRepository;
        this.articleRepository = articleRepository;
        this.chatRepository = chatRepository;

        this.adminRepository = adminRepository;
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAllByStatus(Status.APPROVED);
    }
    @Override
    public void Register(StudentDTO studentDTO) {
        if (!studentRepository.findByMobileNumber(studentDTO.getMobileNumber()).isPresent()) {

            Student student = new Student();
            student.setBacklogs(studentDTO.getBacklogs());
            student.setDepartment(studentDTO.getDepartment());
            student.setPercentage(studentDTO.getPercentage());
            student.setPassword(studentDTO.getPassword());
            student.setUsername(studentDTO.getUsername());
            student.setMobileNumber(studentDTO.getMobileNumber());
            student.setRole("Student");
            student.setStatus(Status.PENDING);
            studentRepository.save(student);


        }
        else{
            System.out.println("Account Already Exists");
        }
    }

    @Override
    public List<Article> findAllByStatus(Status status) {
        return articleRepository.findAllByStatus(Status.APPROVED);
    }

    @Override
    public void login(long mobilenumber, String password) {
        Student student= (Student) studentRepository.findByMobileNumber(mobilenumber).orElseThrow(()->new RuntimeException("no user found"));
        if(student.getPassword().equals(password) && student.getStatus().equals(Status.APPROVED)){
            System.out.println("Logged in Sucessfully");
        }
        else{
            System.out.println("Please re-enter password");
        }
    }
    @Override
    public String addArticle(long mobilenumber, String name, String content){
        Article article=new Article();
        Student student= (Student) studentRepository.findByMobileNumber(mobilenumber).orElseThrow(()->new RuntimeException("no user found"));
        article.setStudent(student);
        article.setContent(content);
        article.setName(name);
        article.setPersonName(student.getUsername());
        article.setPersonRole(student.getRole());
        article.setStatus(Status.PENDING);
        articleRepository.save(article);
       return "your article in pending status it was posted once approved";

    }
//    @Override
//    public List<Article> getAllApprovedArticles() {
////        Article obj = new Article();
//////        List<Article> allArticles = articleRepository.findAllByStatus(Status.APPROVED);
////        String flag = "APPROVED";
////        List<Article> allArticles = new ArrayList<>();
////        if (articleRepository.findAllByStatus(Status.APPROVED).equals(flag)){
////            return allArticles;
////        }
////        return null;
////        List<Article> allArticles = articleRepository.findAllByStatus(Status.APPROVED);
//        return articleRepository.findAllByStatus(Status.APPROVED);
//    }


    @Override
    public Optional<Student> getStudentByName(String username) {
        Student student=new Student();
        student= (Student) studentRepository.findByName(username).orElseThrow(()->new RuntimeException("student not found"));
        if (student.getStatus().equals(Status.APPROVED)){
            return studentRepository.findByName(username);
        }
        return Optional.ofNullable(student);
    }





}
