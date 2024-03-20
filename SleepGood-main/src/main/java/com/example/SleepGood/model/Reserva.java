package com.example.SleepGood.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.*;

import lombok.Data;

@Entity
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido")
    private String cpf;

    @Positive(message = "O número do quarto deve ser positivo")
    private int numeroQuarto;

    @NotBlank(message = "A data de check-in não pode estar em branco")
    private String checkin;

    @NotBlank(message = "A data de check-out não pode estar em branco")
    private String checkout;

    private String Icone;

}
