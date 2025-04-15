package com.example.foyer.services;

import com.example.foyer.entities.Universite;
import java.util.List;

public interface IUniversiteService {
    List<Universite> getAllUniversites();
    Universite getUniversiteById(Long id);
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long id);
    void deleteAllUniversites();
}