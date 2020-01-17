package com.nb.spring.controller;

import com.nb.spring.entity.Lenguaje;
import com.nb.spring.service.ILenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LenguajeController {

    @Autowired
    private ILenguajeService lenguajeService;

    @GetMapping("/lenguajes")
    public ResponseEntity<?> listaLenguajes() {
        List<Lenguaje> listaLenguajes = lenguajeService.findAll();
        if (listaLenguajes != null && listaLenguajes.size() != 0) {
            return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_lenguaje")
    public ResponseEntity<?> agregarLenguaje(@RequestBody Lenguaje lenguaje) {
        lenguajeService.saveLenguaje(lenguaje);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
