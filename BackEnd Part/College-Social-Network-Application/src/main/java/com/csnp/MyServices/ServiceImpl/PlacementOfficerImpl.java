package com.csnp.MyServices.ServiceImpl;

import com.csnp.DTOs.OfficerDTO;
import com.csnp.Enum.Status;
import com.csnp.Models.Article;
import com.csnp.Models.PlacementOfficer;
import com.csnp.Models.Student;
import com.csnp.MyRepositories.ArticleRepository;
import com.csnp.MyRepositories.PlacementOfficerRepository;
import com.csnp.MyRepositories.StudentRepository;
import com.csnp.MyServices.PlacementOfficerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlacementOfficerImpl implements PlacementOfficerService {
	
    private final PlacementOfficerRepository placementOfficerRepository;
	
    private final StudentRepository studentRepository;
	
    private  final ArticleRepository articleRepository;

    @Autowired
    public PlacementOfficerImpl(PlacementOfficerRepository placementOfficerRepository, StudentRepository studentRepository, ArticleRepository articleRepository) {
        this.placementOfficerRepository = placementOfficerRepository;
        this.studentRepository = studentRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Student> getStudentsByCriteria(String department, Integer backlogs, Integer percentage) {
        List<Student> allStudents = studentRepository.findAll();
        List<Student> filteredStudents = new ArrayList<>();

        if (allStudents == null || department == null) {
            // Handle null values gracefully
            return filteredStudents;
        }

        for (Student student : allStudents) {
            if (student.getDepartment() == null || student.getBacklogs() == null || student.getPercentage() == null || student.getStatus().equals(Status.APPROVED)) {
                // Skip iteration if any necessary field is null
                continue;
            }
            if (student.getDepartment().equalsIgnoreCase(department) &&
                    student.getBacklogs() == backlogs &&
                    student.getPercentage() >= percentage) {
                filteredStudents.add(student);
            }
        }

        return filteredStudents;
    }

    @Override
    public void Register(OfficerDTO officerDTO) {
        if (!placementOfficerRepository.findByMobileNumber(officerDTO.getMobileNumber()).isPresent()) {

            PlacementOfficer placementOfficer = new PlacementOfficer();

            placementOfficer.setUsername(officerDTO.getUsername());
            placementOfficer.setMobileNumber(officerDTO.getMobileNumber());
            placementOfficer.setPassword(officerDTO.getPassword());
            placementOfficer.setRole("placement_officer");
            placementOfficer.setStatus(Status.PENDING);
            placementOfficerRepository.save(placementOfficer);


        }
        else{
            System.out.println("Account Already Exists");
        }
    }

    @Override
    public PlacementOfficer login(long mobileNumber, String password) {
        PlacementOfficer placementOfficer= (PlacementOfficer) placementOfficerRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new RuntimeException("no user found"));
        if(placementOfficer.getPassword().equals(password) && placementOfficer.getStatus().equals(Status.APPROVED)){
            System.out.println("Logged in Sucessfully");
        }
        else{
            System.out.println("Please re-enter password");
        }

        return placementOfficer;
    }

    @Override
    public String addArticle(Long mobilenumber, String name,String content) {
        Article article=new Article();
        PlacementOfficer placementOfficer= (PlacementOfficer) placementOfficerRepository.findByMobileNumber(mobilenumber).orElseThrow(()->new RuntimeException("no user found"));
        article.setPlacementOfficer(placementOfficer);
        article.setName(name);
        article.setContent(content);
        article.setStatus(Status.PENDING);
        article.setPersonName(placementOfficer.getUsername());
        article.setPersonRole(placementOfficer.getRole());
        articleRepository.save(article);
        return "your article in pending status it was posted once approved";

    }
}
