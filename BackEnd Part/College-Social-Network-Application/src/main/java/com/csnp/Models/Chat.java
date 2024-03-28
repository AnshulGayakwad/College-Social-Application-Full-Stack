package com.csnp.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Student receiver;

    private String message;

    // Other fields, getters, and setters
}