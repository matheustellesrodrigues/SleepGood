package com.example.SleepGood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SleepGood.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
