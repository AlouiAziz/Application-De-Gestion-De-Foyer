package com.example.foyer.controllers;

import com.example.foyer.entities.Reservation;
import com.example.foyer.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable String id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.updateReservation(reservation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}