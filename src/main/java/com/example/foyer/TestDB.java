package com.example.foyer;

import com.example.foyer.entities.*;
import com.example.foyer.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestDB implements CommandLineRunner {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Autowired
    private FoyerRepository foyerRepository;

    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception {
        // Test de création d'une université
        Universite universite = Universite.builder()
                .nomUniversite("Université Centrale")
                .adresse("123 Rue de l'Université")
                .build();
        universiteRepository.save(universite);

        // Test de création d'un foyer
        Foyer foyer = Foyer.builder()
                .nomFoyer("Foyer Central")
                .capaciteFoyer(200L)
                .build();
        foyerRepository.save(foyer);

        // Test de création d'un bloc
        Bloc bloc = Bloc.builder()
                .nomBloc("Bloc A")
                .capaciteBloc(50L)
                .build();
        blocRepository.save(bloc);

        // Test de création d'une chambre
        Chambre chambre = Chambre.builder()
                .numeroChambre("A101")
                .typeC(TypeChambre.DOUBLE)
                .build();
        chambreRepository.save(chambre);

        // Test de création d'un étudiant
        Etudiant etudiant = Etudiant.builder()
                .nomEt("Dupont")
                .prenomEt("Jean")
                .cin(12345678L)
                .ecole("École d'Ingénieurs")
                .dateNaissance(new Date())
                .build();
        etudiantRepository.save(etudiant);

        // Test de création d'une réservation
        Reservation reservation = Reservation.builder()
                .idReservation("RES2023-001")
                .anneeUniversitaire(new Date())
                .estValide(true)
                .build();
        reservationRepository.save(reservation);

        System.out.println("Test de création des entités terminé avec succès!");
    }
}