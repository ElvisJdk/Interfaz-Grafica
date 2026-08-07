package com.colegio.interfazGrafica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.colegio.interfazGrafica.Entity.Curso;

@Repository
public interface I_CursoRepository extends JpaRepository<Curso,Long>{
    @Query("SELECT c, COUNT(a) FROM Curso c LEFT JOIN c.alumnos a GROUP BY c")
    List<Object[]> cantidadDeAlumnos();


    List<Curso> findByTituloContainingOrProfesorContaining(String titulo, String profesor);



}
