package com.csnp.MyServices.ServiceImpl;

import com.csnp.Enum.Status;
import com.csnp.Exception.AdminException;
import com.csnp.Models.*;
import com.csnp.MyRepositories.*;
import com.csnp.MyServices.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {
	
    private final AdminRepository adminRepository;
	
    private final StudentRepository studentRepository;
	
    private final ArticleRepository articleRepository;
	
    private final StaffRepository staffRepository;
	
    private final PlacementOfficerRepository placementOfficerRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, StudentRepository studentRepository, ArticleRepository articleRepository, StaffRepository staffRepository, PlacementOfficerRepository placementOfficerRepository) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.articleRepository = articleRepository;
        this.staffRepository = staffRepository;
        this.placementOfficerRepository = placementOfficerRepository;
    }
    @Override
    public Admin Login(long mobileNumber,String password) {
        Optional<Admin> obj = adminRepository.findByMobileNumberAndPassword(mobileNumber,password);
        Admin obj1 = obj.orElseThrow(() -> new RuntimeException("Invalid Credetials"));
        return obj1;
    }

    @Override
    public String manageStudentStatus(Long mobileNumber, Status status) {
        Student student = (Student) studentRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (student.getStatus().equals(Status.PENDING)) {
            student.setStatus(status);
            studentRepository.save(student);
            return "Student status updated successfully.";
        } else {
            return "Student is not in a pending status, cannot update.";
        }
    }
    @Override
    public String managePlacementOfficerStatus(Long mobileNumber,Status status){
        PlacementOfficer placementOfficer = (PlacementOfficer) placementOfficerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (placementOfficer.getStatus().equals(Status.PENDING)) {
            placementOfficer.setStatus(status);
            placementOfficerRepository.save(placementOfficer);
            return "placement officer status updated successfully.";
        } else {
            return "placement officer is not in a pending status, cannot update.";
        }
    }
    @Override
    public String manageStaffStatus(Long mobileNumber,Status status){
        Staff staff = (Staff) staffRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (staff.getStatus().equals(Status.PENDING)) {
            staff.setStatus(status);
            staffRepository.save(staff);
            return "staff status updated successfully.";
        } else {
            return "staff is not in a pending status, cannot update.";
        }
    }
    @Override
    public String ArticleApprovalStatus(Long articleId,Status status) throws AdminException {
        // Retrieve pending articles
        Article article=(Article) articleRepository.findById(articleId)
                .orElseThrow(()->new RuntimeException("article not found"));
        if(article.getStatus().equals(Status.PENDING)){
            article.setStatus(status);
            articleRepository.save(article);
            articleRepository.save(article);
            return "article status updated successfully.";
        }
        else{
            return "article is not in a pending status ";
        }
    }

    @Override
    public List<Student> getAllStudents() throws AdminException {
        if(studentRepository.findAll() == null) {
            throw new AdminException("No Students Found");
        }else
            return studentRepository.findAll();
    }

    @Override
    public List<Staff> getAllStaff() throws AdminException{
        if(staffRepository.findAll() == null) {
            throw new AdminException("Staff List Empty !!!");
        }else
            return staffRepository.findAll();
    }

    @Override
    public List<PlacementOfficer> getALlPlacementOfficer() throws AdminException {
        if(placementOfficerRepository.findAll() == null) {
            throw new AdminException("List is empty !!!");
        }else
            return placementOfficerRepository.findAll();
    }

    @Override
    public List<Article> getAllArticles() throws AdminException {
        if(articleRepository.findAll() == null) {
            throw new AdminException("List is Empty !!!");
        }else
            return articleRepository.findAll();
    }

    @Override
    public Admin deleteUsers(Admin admin,Student student, Staff staff, Article article) throws AdminException{
        if(studentRepository.existsById(student.getId())) {
            studentRepository.deleteById(student.getId());
        }else {
            throw new AdminException("Student with the respective id not found !!!");
        }
        if(staffRepository.existsById(staff.getId())) {
            staffRepository.deleteById(staff.getId());
        }else {
            throw new AdminException("Staff with the respective Id not found !11");
        }
        if(articleRepository.existsById(article.getId())) {
            articleRepository.deleteById(article.getId());
        }else {
            throw new AdminException("Article with the respective Id not found !!!");
        }
        return admin;
    }
	
}
