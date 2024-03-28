package com.csnp.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffDTO {
    private String username;
    private String password;
    private Long mobileNumber;
}
