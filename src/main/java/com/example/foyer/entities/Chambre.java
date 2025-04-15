package com.example.foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    @Column(unique = true)
    private String numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    // Relation avec Bloc
    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    // Relation avec Réservation
    @OneToMany(mappedBy = "chambre")
    @Builder.Default
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();
}