package com.csnp.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class StudentDTO {
    private String username;
     private String password;
    private Integer backlogs;
    private String department;
    private Integer percentage;
    private Long mobileNumber;
}
