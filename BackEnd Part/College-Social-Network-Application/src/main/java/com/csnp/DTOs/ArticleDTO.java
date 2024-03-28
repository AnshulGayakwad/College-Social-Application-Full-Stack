package com.csnp.DTOs;

import com.csnp.Enum.Status;
import com.csnp.Models.PlacementOfficer;
import com.csnp.Models.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
        private Long id;
        private String name;
        @Enumerated(EnumType.STRING)
        private Status status;

        private String Content;
        private String personName;
        private String personRole;

    }
