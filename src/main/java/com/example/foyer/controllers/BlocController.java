package com.example.foyer.controllers;

import com.example.foyer.entities.Bloc;
import com.example.foyer.services.IBlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocController {

    @Autowired
    private IBlocService blocService;

    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        return new ResponseEntity<>(blocService.getAllBlocs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        Bloc bloc = blocService.getBlocById(id);
        if (bloc != null) {
            return new ResponseEntity<>(bloc, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Bloc> addBloc(@RequestBody Bloc bloc) {
        return new ResponseEntity<>(blocService.addBloc(bloc), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Bloc> updateBloc(@RequestBody Bloc bloc) {
        return new ResponseEntity<>(blocService.updateBloc(bloc), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}