package com.example.foyer.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    private String idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private boolean estValide;

    // Relation avec Chambre
    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    // Réservation est le parent dans la relation Reservation-Etudiant
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reservation_etudiant",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    @Builder.Default
    private Set<Etudiant> etudiants = new HashSet<>();
}