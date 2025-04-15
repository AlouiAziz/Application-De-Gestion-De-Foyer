package com.example.foyer.controllers;

import com.example.foyer.entities.Universite;
import com.example.foyer.services.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    private IUniversiteService universiteService;

    @GetMapping
    public ResponseEntity<List<Universite>> getAllUniversites() {
        return new ResponseEntity<>(universiteService.getAllUniversites(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable Long id) {
        Universite universite = universiteService.getUniversiteById(id);
        if (universite != null) {
            return new ResponseEntity<>(universite, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite universite) {
        return new ResponseEntity<>(universiteService.addUniversite(universite), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Universite> updateUniversite(@RequestBody Universite universite) {
        return new ResponseEntity<>(universiteService.updateUniversite(universite), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}