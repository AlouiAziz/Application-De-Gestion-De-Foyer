package com.example.foyer.services;

import com.example.foyer.entities.Foyer;
import com.example.foyer.entities.Universite;
import com.example.foyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite universite) {
        // Pour l'ajout de l'université, il faut créer en même temps son foyer
        if (universite.getFoyer() == null) {
            Foyer foyer = new Foyer();
            foyer.setNomFoyer("Foyer de " + universite.getNomUniversite());
            foyer.setCapaciteFoyer(0L);
            universite.setFoyer(foyer);
        }
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(Long id) {
        // Pour la suppression de l'université, on doit supprimer en même temps son foyer
        // Cela est géré automatiquement grâce au CascadeType.ALL dans l'entité Universite
        universiteRepository.deleteById(id);
    }

    @Override
    public void deleteAllUniversites() {
        universiteRepository.deleteAll();
    }
}