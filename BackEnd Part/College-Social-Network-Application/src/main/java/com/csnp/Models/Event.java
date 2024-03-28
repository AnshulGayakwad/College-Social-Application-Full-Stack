package com.csnp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.csnp.Enum.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private LocalDateTime eventDate;
    private String eventLocation;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

}

