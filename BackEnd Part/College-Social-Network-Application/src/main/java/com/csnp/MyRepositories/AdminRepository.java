package com.csnp.MyRepositories;

import com.csnp.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {


	 @Query("SELECT a FROM Admin a WHERE a.username = :username")
	    Optional<Admin> findByName(@Param("username") String username);

	@Query("SELECT a FROM Admin a WHERE a.mobileNumber = :mobileNumber AND a.password = :password")
	Optional<Admin> findByMobileNumberAndPassword(@Param("mobileNumber") long mobileNumber, @Param("password") String password);
}
