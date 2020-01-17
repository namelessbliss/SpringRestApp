package com.nb.spring.controller;

import com.nb.spring.entity.Curso;
import com.nb.spring.entity.Profesor;
import com.nb.spring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CursoRestController {

    @Autowired
    private ICursoService cursoService;

    @GetMapping("/cursos")
    public ResponseEntity<?> listaCursos() {
        List<Curso> listaCursos = cursoService.findAll();
        if (listaCursos != null) {
            if (listaCursos.size() != 0) {
                return new ResponseEntity<>(listaCursos, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_curso")
    public ResponseEntity<?> agregarCurso(@RequestBody Curso curso) {
        cursoService.saveCurso(curso);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/curso_profesor")
    public ResponseEntity<?> verCursosProfesor(@RequestBody Profesor profesor) {
        List<Curso> listaCursos = cursoService.getCursosProfesor(profesor.getId());
        if (listaCursos != null) {
            if (listaCursos.size() != 0) {
                return new ResponseEntity<>(listaCursos, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
