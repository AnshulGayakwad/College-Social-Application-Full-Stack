package com.csnp.MyRepositories;

import com.csnp.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	@Query("SELECT e FROM Staff e WHERE e.username = :username")
    Optional<Staff> findByName(@Param("username") String username);

    @Query("SELECT e FROM Staff e WHERE e.mobileNumber = :mobileNumber")
    Optional<Staff> findByMobileNumber(@Param("mobileNumber") Long mobileNumber);
}