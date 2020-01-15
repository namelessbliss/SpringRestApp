package com.nb.spring.service;

import com.nb.spring.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface IProfesorService {

    public List<Profesor> findAll();

    public void save(Profesor profesor);

    public Profesor findProfesor(Profesor profesor);

    public Profesor checkProfesorLogin(String email, String password);

    public void deleteProfesor(Profesor profesor);

    public Profesor updateProfesor(Profesor profesor);

    public Optional<Profesor> findProfesorById(Long profesor_id);

    public void deleteProfesor(Long id);

    public void deleteAllProfesor();

    public Profesor findById(Long id);

    public Profesor findByIdSQL(Long id);
}
