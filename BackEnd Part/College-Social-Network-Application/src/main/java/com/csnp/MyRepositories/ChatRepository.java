package com.csnp.MyRepositories;

import com.csnp.Models.Chat;
import com.csnp.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    }