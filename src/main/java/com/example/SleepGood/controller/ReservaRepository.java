package com.example.SleepGood.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SleepGood.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Se necessário, adicione métodos personalizados aqui
}
