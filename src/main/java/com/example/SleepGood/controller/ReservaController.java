package com.example.SleepGood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.SleepGood.model.Reserva;
import com.example.SleepGood.repository.ReservaRepository;

import jakarta.validation.Valid;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/Reserva")
    @ResponseBody
    public List<Reserva> index() {
        return reservaRepository.findAll();
    }

    @PostMapping("/Reserva")
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody Reserva reserva, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Erro de validação: " + result.getAllErrors());
        }
        Reserva savedReserva = reservaRepository.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReserva);
    }

    @GetMapping("/Reserva/{id}")
    @ResponseBody
    public ResponseEntity<Reserva> get(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
