package com.example.gtics_lab7_20201638.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "technician")
@Getter
@Setter
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technicianid")
    private int id;

    @NotBlank
    @Size(max=100, message = "El nombre no puede tener más de 100 caracteres")
    @Column(nullable = false)
    private String firstname;

    @NotBlank
    @Size(max=100, message = "El apellido no puede tener más de 100 caracteres")
    @Column(nullable = false)
    private String lastname;

    @Positive
    @Digits(integer = 8, fraction = 0)
    @Column(nullable = false)
    private int dni;

    @Positive
    @Digits(integer = 9, fraction = 0)
    @Column(nullable = false)
    private int phone;

    @Positive
    @Column(nullable = false)
    private int age;
}
