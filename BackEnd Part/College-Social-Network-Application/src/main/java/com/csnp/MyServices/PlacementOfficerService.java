package com.csnp.MyServices;

import java.util.List;

import com.csnp.DTOs.OfficerDTO;
import com.csnp.Models.PlacementOfficer;
import com.csnp.Models.Student;

public interface PlacementOfficerService {

    public List<Student> getStudentsByCriteria(String department, Integer backlogs, Integer percentage);

    public void Register(OfficerDTO officerDTO);
    PlacementOfficer login(long mobileNumber, String password);
;



    String addArticle(Long mobilenumber, String name, String content);
}