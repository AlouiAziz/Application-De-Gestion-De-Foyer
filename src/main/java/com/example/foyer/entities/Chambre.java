package com.example.foyer.entities;

import jakarta.persistence.*;
import lombok.*;

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

    // NumeroChambre est unique comme indiqué dans le TP
    @Column(unique = true)
    private String numeroChambre;

    // Enumération pour le type de chambre
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
}