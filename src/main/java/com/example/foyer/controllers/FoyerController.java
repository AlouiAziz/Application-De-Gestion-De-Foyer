package com.example.foyer.controllers;

import com.example.foyer.entities.Foyer;
import com.example.foyer.services.IFoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerController {

    @Autowired
    private IFoyerService foyerService;

    @GetMapping
    public ResponseEntity<List<Foyer>> getAllFoyers() {
        return new ResponseEntity<>(foyerService.getAllFoyers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getFoyerById(@PathVariable Long id) {
        Foyer foyer = foyerService.getFoyerById(id);
        if (foyer != null) {
            return new ResponseEntity<>(foyer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer) {
        return new ResponseEntity<>(foyerService.addFoyer(foyer), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Foyer> updateFoyer(@RequestBody Foyer foyer) {
        return new ResponseEntity<>(foyerService.updateFoyer(foyer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}