package com.csnp.MyControllers;

import com.csnp.Enum.Status;
import com.csnp.Exception.AdminException;
import com.csnp.Exception.InvalidCredentialsException;
import com.csnp.Models.*;
import com.csnp.MyServices.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
     
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login/{mobileNumber}/{password}")
    public ResponseEntity<?> login(@PathVariable long mobileNumber, @PathVariable String password) {
        try {
            Admin admin = adminService.Login(mobileNumber, password);
            return ResponseEntity.ok(admin);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PutMapping("/students/{mobileNumber}/{status}")
    public ResponseEntity<String> manageStudentStatus(@PathVariable Long mobileNumber, @PathVariable String status) {
        String message = adminService.manageStudentStatus(mobileNumber, Status.valueOf(status));
        return ResponseEntity.ok(message);
    }

    @PutMapping("/placementOfficers/{mobileNumber}/{status}")
    public ResponseEntity<String> managePlacementOfficerStatus(@PathVariable Long mobileNumber, @PathVariable Status status) {
        String message = adminService.managePlacementOfficerStatus(mobileNumber, status);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/staff/{mobileNumber}/{status}")
    public ResponseEntity<String> manageStaffStatus(@PathVariable Long mobileNumber, @PathVariable Status status) {
        String message = adminService.manageStaffStatus(mobileNumber, status);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/articles/{articleId}/status")
    public ResponseEntity<String> articleApprovalStatus(@PathVariable Long articleId,Status status) {
       String message= adminService.ArticleApprovalStatus(articleId,status);
       return ResponseEntity.ok(message);
        }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = adminService.getAllStudents();
            return ResponseEntity.ok(students);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/staff")
    public ResponseEntity<List<Staff>> getAllStaff() {
        try {
            List<Staff> staffList = adminService.getAllStaff();
            return ResponseEntity.ok(staffList);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/placementOfficers")
    public ResponseEntity<List<PlacementOfficer>> getAllPlacementOfficers() {
        try {
            List<PlacementOfficer> placementOfficers = adminService.getALlPlacementOfficer();
            return ResponseEntity.ok(placementOfficers);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        try {
            List<Article> articles = adminService.getAllArticles();
            return ResponseEntity.ok(articles);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<Admin> deleteUsers(@RequestBody Admin admin, @RequestParam Student student, @RequestParam Staff staff, @RequestParam Article article) {
//        try {
//            Admin deletedAdmin = adminService.deleteUsers(admin, student, staff, article);
//            return ResponseEntity.ok(deletedAdmin);
//        } catch (AdminException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}
