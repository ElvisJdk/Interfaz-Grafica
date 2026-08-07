package com.colegio.interfazGrafica.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.interfazGrafica.Entity.Alumno;

@Repository
public interface I_AlumnoRepository extends JpaRepository<Alumno,Long>{
     
    List<Alumno> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
    
    }
