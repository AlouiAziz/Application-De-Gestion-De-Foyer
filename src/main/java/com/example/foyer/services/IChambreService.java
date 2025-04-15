package com.example.foyer.services;

import com.example.foyer.entities.Chambre;
import java.util.List;

public interface IChambreService {
    List<Chambre> getAllChambres();
    Chambre getChambreById(Long id);
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(Long id);
    void deleteAllChambres();
}