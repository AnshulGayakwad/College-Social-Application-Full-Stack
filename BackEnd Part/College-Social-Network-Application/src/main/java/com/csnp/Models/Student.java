package com.csnp.Models;

import com.csnp.Enum.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    private String department;
    private Integer backlogs;
    private Integer percentage;
    @OneToMany(mappedBy = "student")
    private List<Article> articles;
    @OneToMany(mappedBy="student")
    private List<Chat> chats;

    @Enumerated(EnumType.STRING)
    private Status status;
    // Other fields, getters, and setters
}
