package com.example.foyer.services;

import com.example.foyer.entities.Reservation;
import com.example.foyer.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void deleteAllReservations() {
        reservationRepository.deleteAll();
    }
}