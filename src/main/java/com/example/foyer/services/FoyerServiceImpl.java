package com.example.foyer.services;

import com.example.foyer.entities.Foyer;
import com.example.foyer.repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void deleteAllFoyers() {
        foyerRepository.deleteAll();
    }
}