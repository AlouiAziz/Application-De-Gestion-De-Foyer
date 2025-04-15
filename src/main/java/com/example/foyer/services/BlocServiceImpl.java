package com.example.foyer.services;

import com.example.foyer.entities.Bloc;
import com.example.foyer.entities.Chambre;
import com.example.foyer.entities.TypeChambre;
import com.example.foyer.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    private BlocRepository blocRepository;

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        // Pour l'ajout d'un bloc, il faut créer en même temps ses chambres
        if (bloc.getChambres() == null || bloc.getChambres().isEmpty()) {
            // Création de chambres par défaut (exemple)
            Set<Chambre> chambres = new HashSet<>();
            for (int i = 1; i <= 5; i++) {
                Chambre chambre = new Chambre();
                chambre.setNumeroChambre(bloc.getNomBloc() + "-" + i);
                chambre.setTypeC(TypeChambre.SIMPLE); // Type par défaut
                chambre.setBloc(bloc);
                chambres.add(chambre);
            }
            bloc.setChambres(chambres);
        } else {
// S'assurer que chaque chambre est liée à ce bloc
            for (Chambre chambre : bloc.getChambres()) {
                chambre.setBloc(bloc);
            }
        }
        return blocRepository.save(bloc);
    }
    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        // Pour la suppression d'un bloc, on doit supprimer en même temps ses chambres
        // Cela est géré automatiquement grâce au CascadeType.ALL dans l'entité Bloc
        blocRepository.deleteById(id);
    }

    @Override
    public void deleteAllBlocs() {
        blocRepository.deleteAll();
    }

}
