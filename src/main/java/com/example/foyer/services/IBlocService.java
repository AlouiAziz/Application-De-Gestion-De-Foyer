package com.example.foyer.services;

import com.example.foyer.entities.Bloc;
import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
    Bloc getBlocById(Long id);
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Long id);
    void deleteAllBlocs();
}