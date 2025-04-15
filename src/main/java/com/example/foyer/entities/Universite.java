package com.example.foyer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    private String nomUniversite;
    private String adresse;

    // Université est le parent dans la relation Universite-Foyer
    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyer;
}