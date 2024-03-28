package com.csnp.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OfficerDTO {
    private String username;
    private String password;
    private Long mobileNumber;
}
