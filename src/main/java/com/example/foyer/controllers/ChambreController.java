package com.example.foyer.controllers;

import com.example.foyer.entities.Chambre;
import com.example.foyer.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
public class ChambreController {

    @Autowired
    private IChambreService chambreService;

    @GetMapping
    public ResponseEntity<List<Chambre>> getAllChambres() {
        return new ResponseEntity<>(chambreService.getAllChambres(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Chambre chambre = chambreService.getChambreById(id);
        if (chambre != null) {
            return new ResponseEntity<>(chambre, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre) {
        return new ResponseEntity<>(chambreService.addChambre(chambre), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Chambre> updateChambre(@RequestBody Chambre chambre) {
        return new ResponseEntity<>(chambreService.updateChambre(chambre), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}