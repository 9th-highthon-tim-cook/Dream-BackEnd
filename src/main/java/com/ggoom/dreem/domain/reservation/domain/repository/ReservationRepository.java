package com.ggoom.dreem.domain.reservation.domain.repository;

import com.ggoom.dreem.domain.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
