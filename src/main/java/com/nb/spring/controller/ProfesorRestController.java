package com.nb.spring.controller;

import com.nb.spring.entity.Profesor;
import com.nb.spring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping("/profesores")
    @ResponseStatus(HttpStatus.OK)
    public List<Profesor> getProfesores() {
        return profesorService.findAll();
    }

    @PostMapping("/sign_up")
    public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {
        if (profesorService.findProfesor(profesor) == null) {
            profesorService.save(profesor);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{id}") //se pasa parametro id
    public ResponseEntity<?> updateProfesor(@PathVariable(value = "id") Long id, @RequestBody Profesor profesor) {
        Profesor profesorFromDB = null;
        profesorFromDB = profesorService.findById(id); //Encuentra por el id pasado como parametro
        if (profesorFromDB != null) {
            profesorFromDB.setEmail(profesor.getEmail());
            profesorFromDB.setNombre(profesor.getNombre());
            profesorService.updateProfesor(profesorFromDB);
            return new ResponseEntity<>(profesorFromDB, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable(value = "id") Long id) {
        Profesor profesorFromDB = null;
        profesorFromDB = profesorService.findById(id); //Encuentra por el id pasado como parametro
        if (profesorFromDB != null) {
            profesorService.deleteProfesor(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
