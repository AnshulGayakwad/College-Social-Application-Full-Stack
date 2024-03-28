package com.csnp.MyRepositories;

import com.csnp.Models.PlacementOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlacementOfficerRepository extends JpaRepository<PlacementOfficer, Long> {
	@Query("SELECT e FROM PlacementOfficer e WHERE e.mobileNumber = :mobileNumber")
    Optional<PlacementOfficer> findByMobileNumber(@Param("mobileNumber") Long mobileNumber);

    @Query("SELECT e FROM PlacementOfficer e WHERE e.username = :username")
    Optional<PlacementOfficer> findByName(@Param("username") String username);
}