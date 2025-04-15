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
        // Création d'un foyer
        Foyer foyer = Foyer.builder()
                .nomFoyer("Foyer Central")
                .capaciteFoyer(200L)
                .build();

        // Création d'une université avec son foyer
        Universite universite = Universite.builder()
                .nomUniversite("Université Centrale")
                .adresse("123 Rue de l'Université")
                .foyer(foyer)
                .build();

        // Sauvegarde de l'université (le foyer sera sauvegardé en cascade)
        universiteRepository.save(universite);

        // Création d'un bloc lié au foyer
        Bloc bloc = Bloc.builder()
                .nomBloc("Bloc A")
                .capaciteBloc(50L)
                .foyer(foyer)
                .build();

        // Sauvegarde du bloc
        blocRepository.save(bloc);

        // Création d'une chambre liée au bloc
        Chambre chambre = Chambre.builder()
                .numeroChambre("A101")
                .typeC(TypeChambre.DOUBLE)
                .bloc(bloc)
                .build();

        // Sauvegarde de la chambre
        chambreRepository.save(chambre);

        // Création d'un étudiant
        Etudiant etudiant = Etudiant.builder()
                .nomEt("Dupont")
                .prenomEt("Jean")
                .cin(12345678L)
                .ecole("École d'Ingénieurs")
                .dateNaissance(new Date())
                .build();

        // Sauvegarde de l'étudiant
        etudiantRepository.save(etudiant);

        // Création d'une réservation liée à la chambre et à l'étudiant
        Reservation reservation = Reservation.builder()
                .idReservation("RES2023-001")
                .anneeUniversitaire(new Date())
                .estValide(true)
                .chambre(chambre)
                .build();

        // Ajout de l'étudiant à la réservation
        reservation.getEtudiants().add(etudiant);

        // Sauvegarde de la réservation
        reservationRepository.save(reservation);

        System.out.println("Test de création des entités avec associations terminé avec succès!");
    }
}