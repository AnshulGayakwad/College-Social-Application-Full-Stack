package com.csnp.MyRepositories;

import com.csnp.Enum.Status;
import com.csnp.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {


	@Query("SELECT s FROM Student s WHERE s.mobileNumber = :mobileNumber")
    Optional<Student> findByMobileNumber(@Param("mobileNumber") Long mobileNumber);

    @Query("SELECT s FROM Student s WHERE s.username = :username")
    Optional<Student> findByName(@Param("username") String username);

    @Query("SELECT s FROM Student s WHERE s.department = :department AND s.backlogs = :backlogs AND s.percentage = :percentage")
    List<Student> findByDepartmentAndBacklogsAndPercentage(@Param("department") String department, @Param("backlogs") Integer backlogs, @Param("percentage") Integer percentage);

    @Query("SELECT s FROM Student s WHERE s.status = :status")
    List<Student> findAllByStatus(Status status);
}

//        Optional<Student> findByName(String name);
//
//        Optional<Student> findByMobileNumber(long mobileNumber);

