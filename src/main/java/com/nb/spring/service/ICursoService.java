package com.nb.spring.service;

import com.nb.spring.entity.Curso;

import java.util.List;

public interface ICursoService {

    public List<Curso> findAll();

    public void saveCurso(Curso curso);

    public List<Curso> getCursosProfesor(Long id);
}
