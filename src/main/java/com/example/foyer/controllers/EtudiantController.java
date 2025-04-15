package com.example.foyer.controllers;

import com.example.foyer.entities.Etudiant;
import com.example.foyer.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private IEtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        return new ResponseEntity<>(etudiantService.getAllEtudiants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(etudiantService.addEtudiant(etudiant), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(etudiantService.updateEtudiant(etudiant), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}