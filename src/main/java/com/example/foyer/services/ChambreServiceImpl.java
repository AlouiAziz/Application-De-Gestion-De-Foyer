package com.example.foyer.services;

import com.example.foyer.entities.Chambre;
import com.example.foyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public void deleteAllChambres() {
        chambreRepository.deleteAll();
    }
}