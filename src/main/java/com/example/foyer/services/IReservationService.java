package com.example.foyer.services;

import com.example.foyer.entities.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(String id);
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(String id);
    void deleteAllReservations();
}