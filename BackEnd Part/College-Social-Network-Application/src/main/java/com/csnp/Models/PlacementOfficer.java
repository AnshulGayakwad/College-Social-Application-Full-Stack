package com.csnp.Models;

import com.csnp.Enum.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class PlacementOfficer extends User {
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "placementOfficer")
    private List<Article> articles;
}
