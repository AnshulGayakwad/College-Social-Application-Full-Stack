package com.csnp.MyControllers;

import com.csnp.DTOs.OfficerDTO;
import com.csnp.Exception.InvalidCredentialsException;
import com.csnp.Models.PlacementOfficer;
import com.csnp.Models.Student;
import com.csnp.MyServices.PlacementOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/placement-officer")
public class PlacementOfficerController {
     
    private final PlacementOfficerService placementOfficerService;

    @Autowired
    public PlacementOfficerController(PlacementOfficerService placementOfficerService) {
        this.placementOfficerService = placementOfficerService;
    }

    @PostMapping("/register")
    public void registerPlacementOfficer(@RequestBody OfficerDTO officerDTO) {
        placementOfficerService.Register(officerDTO);
    }

    @GetMapping("/login/{mobileNumber}/{password}")
    public ResponseEntity<?> login(@PathVariable long mobileNumber, @PathVariable String password) {
        try {
            PlacementOfficer placementOfficer = placementOfficerService.login(mobileNumber, password);
            return ResponseEntity.ok(placementOfficer);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/add-article")
    public String addArticle(@RequestParam Long mobileNumber,
                                     @RequestParam String name,
                                     @RequestParam String content) {
        return placementOfficerService.addArticle(mobileNumber,name, content);
    }
    @GetMapping("/getStudentsByFilter/{department}/{backlogs}/{percentage}")
    public List<Student> getStudentsByCriteria(@PathVariable String department, @PathVariable Integer backlogs, @PathVariable Integer percentage) {
        return placementOfficerService.getStudentsByCriteria(department, backlogs, percentage);
    }

}
