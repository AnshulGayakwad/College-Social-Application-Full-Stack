package com.csnp.MyRepositories;


import com.csnp.Enum.Status;
import com.csnp.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
//	@Query("SELECT e FROM Event e WHERE e.status = :status")
//    List<Event> findByStatus(@Param("status") Status status);
}