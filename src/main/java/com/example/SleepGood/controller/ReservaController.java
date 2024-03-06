package com.example.SleepGood.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SleepGood.model.Reserva;

@Controller
public class ReservaController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<Reserva> repository = new ArrayList<>();

    @RequestMapping(method=RequestMethod.GET , path="/Reserva")//n precisa mais d: produces = "application/json"
    public List<Reserva> index(){
        return repository;
    }
    //@ResponseStatus(code = HttpStatus.CREATED)//vai responder com 201, q é o codigo d criação
    @RequestMapping(method=RequestMethod.POST ,path="/Reserva")
    @ResponseBody
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva){
        // categoria.setId(new Random().nextLong()); //esse codigo é responsabilidade da Categoria, e n deve estar aqui
        log.info("cadastrando Reservas: {}", reserva);
        repository.add(reserva);
        return ResponseEntity.status(201).body(reserva);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/Reserva/{id}")
    @ResponseBody
    public ResponseEntity<Reserva> get (@PathVariable Long id) {
        log.info("buscando Reserva com id {}", id);

        //stream
        var reserva = repository
            .stream()
            .filter(c -> c.id().equals(id))
            .findFirst(); //esses codigo filtra por id e pega o primeiro resultado
        
        if (reserva.isEmpty()){
                return ResponseEntity.status(404).build();
            }
                return ResponseEntity.status(200).body(reserva.get());
    }


}
