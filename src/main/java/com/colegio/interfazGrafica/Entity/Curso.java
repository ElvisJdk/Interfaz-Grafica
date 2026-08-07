package com.colegio.interfazGrafica.Entity;


import java.util.ArrayList;
import java.util.List;

import com.colegio.interfazGrafica.Enums.Dia;
import com.colegio.interfazGrafica.Enums.Turno;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn (name = "titulo")
    private String titulo;

    @JoinColumn (name = "profesor")
    private String profesor;

    @Enumerated(EnumType.STRING)
    private Dia dia;

    @Enumerated(EnumType.STRING)
    private Turno Turno;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> alumnos = new ArrayList<>();

}
