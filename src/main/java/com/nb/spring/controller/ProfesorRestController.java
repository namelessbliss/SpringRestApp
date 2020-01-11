package com.nb.spring.controller;

import com.nb.spring.entity.Profesor;
import com.nb.spring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
