package com.csnp.MyServices;

import com.csnp.Enum.Status;
import com.csnp.Exception.AdminException;
import com.csnp.Models.*;

import java.util.List;

import org.springframework.stereotype.Service;

public interface AdminService {
      Admin Login(long mobileNumber, String password);

      //        @Override
  //        public List<Student> StudentRegistrationStatus() throws AdminException {
  //            return studentRepository.findAll();
  //        }
  //
  //        @Override
  //        public List<Staff> StaffRegistrationStatus () throws AdminException{
  //            return staffRepository.findAll();
  //
  //        }
      String manageStudentStatus(Long mobileNumber, Status status);

      String managePlacementOfficerStatus(Long mobileNumber, Status status);

      String manageStaffStatus(Long mobileNumber, Status status);


    String ArticleApprovalStatus(Long articleId, Status status) throws AdminException;

    List<Student> getAllStudents();

      List<Staff> getAllStaff();
      List<PlacementOfficer> getALlPlacementOfficer();
      List<Article> getAllArticles();





      Admin deleteUsers(Admin admin, Student student, Staff staff, Article article) throws AdminException;

	
}
