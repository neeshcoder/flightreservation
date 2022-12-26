package com.neesh.flight_reservation_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neesh.flight_reservation_app.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
