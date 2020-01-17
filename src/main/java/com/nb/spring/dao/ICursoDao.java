package com.nb.spring.dao;

import com.nb.spring.entity.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICursoDao extends CrudRepository<Curso, Long> {

    public List<Curso> findProfesorByID(Long id);
}
