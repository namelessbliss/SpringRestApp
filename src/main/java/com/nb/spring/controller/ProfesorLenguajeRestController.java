package com.nb.spring.controller;

import com.nb.spring.entity.Lenguaje;
import com.nb.spring.entity.Profesor;
import com.nb.spring.model.ProfesorLenguaje;
import com.nb.spring.service.ILenguajeService;
import com.nb.spring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ProfesorLenguajeRestController {

    @Autowired
    private ILenguajeService lenguajeService;

    @Autowired
    private IProfesorService profesorService;

    @PostMapping("/lenguajes_profesor")
    public ResponseEntity<?> listaLenguajesProfesor(@RequestBody Profesor profesor) {
        Profesor profesorFromDb = profesorService.findById(profesor.getId());
        if (profesorFromDb != null) {
            Collection<Lenguaje> listaLenguajes = profesorFromDb.getLenguajes();
            if (listaLenguajes != null) {
                return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save_lenguaje_profesor")
    public ResponseEntity<?> saveLenguajeProfesor(@RequestBody ProfesorLenguaje profesorLenguaje) {
        Profesor profesorFromDb = profesorService.findById(profesorLenguaje.getProfesor().getId());
        if (profesorFromDb != null) {
            Lenguaje lenguajeFromDb = lenguajeService.findLenguajeById(profesorLenguaje.getLenguaje().getId());
            profesorFromDb.addLenguaje(lenguajeFromDb);
            profesorService.save(profesorFromDb);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
