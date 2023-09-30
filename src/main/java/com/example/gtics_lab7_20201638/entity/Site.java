package com.example.gtics_lab7_20201638.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "site")
@Getter
@Setter
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "siteid")
    private int id;

    @Column(nullable = false)
    private String sitename;


    @Column(nullable = false)
    private int locationid;

    @Column(nullable = false)
    private BigDecimal latitude;


    @Column(nullable = false)
    private BigDecimal longitude;
}
