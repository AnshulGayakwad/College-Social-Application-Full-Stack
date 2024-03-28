package com.csnp.Models;

import com.csnp.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends User {
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<Event> event;


}