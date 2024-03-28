package com.csnp.Models;

import com.csnp.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String personName;
    private String personRole;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties("articles")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "plc_id")
    @JsonIgnoreProperties("articles")
    private PlacementOfficer placementOfficer;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String Content;
    private byte[] image;

}