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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private Long capaciteBloc;

    // Relation avec Foyer
    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    // Relation avec Chambre
    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    @Builder.Default
    @JsonIgnore
    private Set<Chambre> chambres = new HashSet<>();
}