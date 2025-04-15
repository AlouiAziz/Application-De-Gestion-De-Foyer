package com.example.foyer.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;

    // Relation avec Université (inverse)
    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    // Relation avec Bloc
    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Bloc> blocs = new HashSet<>();
}