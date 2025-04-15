package com.example.foyer.services;

import com.example.foyer.entities.Foyer;
import java.util.List;

public interface IFoyerService {
    List<Foyer> getAllFoyers();
    Foyer getFoyerById(Long id);
    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    void deleteFoyer(Long id);
    void deleteAllFoyers();
}