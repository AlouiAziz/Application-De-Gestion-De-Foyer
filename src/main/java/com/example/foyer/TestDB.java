package com.example.foyer;

import com.example.foyer.entities.*;
import com.example.foyer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestDB implements CommandLineRunner {

    @Autowired
    private IUniversiteService universiteService;

    @Autowired
    private IFoyerService foyerService;

    @Autowired
    private IBlocService blocService;

    @Autowired
    private IChambreService chambreService;

    @Autowired
    private IEtudiantService etudiantService;

    @Autowired
    private IReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {
        // Nettoyage des tables (ordre important à respecter pour éviter les violations de contraintes)
        reservationService.deleteAllReservations();
        etudiantService.deleteAllEtudiants();
        chambreService.deleteAllChambres();
        blocService.deleteAllBlocs();
        universiteService.deleteAllUniversites();
        foyerService.deleteAllFoyers();

        System.out.println("Toutes les tables ont été nettoyées.");

        // Test 1: Ajout d'une université avec son foyer
        Foyer foyer = Foyer.builder()
                .nomFoyer("Foyer Central")
                .capaciteFoyer(200L)
                .build();

        Universite universite = Universite.builder()
                .nomUniversite("Université Centrale")
                .adresse("123 Rue de l'Université")
                .foyer(foyer)
                .build();

        universite = universiteService.addUniversite(universite);
        System.out.println("Université et foyer créés avec succès: " + universite.getNomUniversite() + " - " + universite.getFoyer().getNomFoyer());

        // Test 2: Ajout d'un bloc avec ses chambres
        Bloc bloc = Bloc.builder()
                .nomBloc("Bloc A")
                .capaciteBloc(50L)
                .foyer(foyer)
                .build();

        // Création de chambres pour le bloc
        Set<Chambre> chambres = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            Chambre chambre = Chambre.builder()
                    .numeroChambre("A" + i)
                    .typeC(i % 3 == 0 ? TypeChambre.TRIPLE : (i % 2 == 0 ? TypeChambre.DOUBLE : TypeChambre.SIMPLE))
                    .bloc(bloc)
                    .build();
            chambres.add(chambre);
        }
        bloc.setChambres(chambres);

        bloc = blocService.addBloc(bloc);
        System.out.println("Bloc créé avec succès: " + bloc.getNomBloc() + " avec " + bloc.getChambres().size() + " chambres");

        // Test 3: Ajout d'étudiants
        Etudiant etudiant1 = Etudiant.builder()
                .nomEt("Dupont")
                .prenomEt("Jean")
                .cin(12345678L)
                .ecole("École d'Ingénieurs")
                .dateNaissance(new Date())
                .build();

        Etudiant etudiant2 = Etudiant.builder()
                .nomEt("Martin")
                .prenomEt("Sophie")
                .cin(87654321L)
                .ecole("École de Commerce")
                .dateNaissance(new Date())
                .build();

        etudiant1 = etudiantService.addEtudiant(etudiant1);
        etudiant2 = etudiantService.addEtudiant(etudiant2);
        System.out.println("Étudiants créés avec succès: " + etudiant1.getNomEt() + " et " + etudiant2.getNomEt());

        // Test 4: Ajout d'une réservation
        Chambre chambre = chambreService.getAllChambres().get(0);

        Reservation reservation = Reservation.builder()
                .idReservation("RES" + System.currentTimeMillis())
                .anneeUniversitaire(new Date())
                .estValide(true)
                .chambre(chambre)
                .build();

        // Ajout des étudiants à la réservation
        Set<Etudiant> etudiantsReservation = new HashSet<>();
        etudiantsReservation.add(etudiant1);
        etudiantsReservation.add(etudiant2);
        reservation.setEtudiants(etudiantsReservation);

        reservation = reservationService.addReservation(reservation);
        System.out.println("Réservation créée avec succès: " + reservation.getIdReservation() + " pour chambre " +
                reservation.getChambre().getNumeroChambre() + " avec " + reservation.getEtudiants().size() + " étudiants");

        // Test 5: Mise à jour d'une université
        universite.setAdresse("456 Avenue des Sciences");
        universite = universiteService.updateUniversite(universite);
        System.out.println("Université mise à jour avec succès: " + universite.getNomUniversite() + " - " + universite.getAdresse());

        // Test 6: Suppression d'un bloc (qui devrait également supprimer ses chambres)
        // Long blocId = bloc.getIdBloc();
        // blocService.deleteBloc(blocId);
        // System.out.println("Bloc supprimé avec succès avec l'ID: " + blocId);

        // Vérification que le bloc a bien été supprimé
        // Bloc blocSupprime = blocService.getBlocById(blocId);
        //System.out.println("Bloc après suppression: " + (blocSupprime == null ? "Supprimé avec succès" : "Échec de la suppression"));

        System.out.println("Tests terminés avec succès!");
    }
}
