package com.colegio.interfazGrafica.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.colegio.interfazGrafica.Entity.Curso;
import com.colegio.interfazGrafica.Repository.I_CursoRepository;


@Controller
public class ControllerCurso {
    @Autowired
    private I_CursoRepository cursoRepository;
    
    


    @GetMapping("/cursos")
    public String listaCursos(@RequestParam (required = false) String buscarC, Model model) {
        List<Curso> cursos; 
        List<Object[]> alumnosPorCursos = cursoRepository.cantidadDeAlumnos();
        Curso curso = new Curso();

        if (buscarC != null && !buscarC.isEmpty()) {
            cursos = cursoRepository.findByTituloContainingOrProfesorContaining(buscarC, buscarC);
        } else {
            cursos = cursoRepository.findAll();
        }
        
        model.addAttribute("cursoHtmlTabla", cursos);
        model.addAttribute("cursoGuardar",curso);
        model.addAttribute("alumnosPorCursos", alumnosPorCursos);
        return "cursos";
    }
     @PostMapping("/guardar")
     public String guardar(@ModelAttribute("cursoGuardar") Curso cr){
        cursoRepository.save(cr);
        return "redirect:cursos";
    }
    
    
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping ("/borrar/{id}")
    public String borrar(@PathVariable (name = "id") Long id){
        cursoRepository.deleteById(id);
         return "redirect:/cursos";

    }
    
 
        
        
    
   
    
}
