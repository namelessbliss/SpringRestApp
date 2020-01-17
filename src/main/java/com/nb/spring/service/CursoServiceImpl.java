package com.nb.spring.service;

import com.nb.spring.dao.ICursoDao;
import com.nb.spring.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoDao cursoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return (List<Curso>) cursoDao.findAll();
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    public List<Curso> getCursosProfesor(Long id) {
        return (List<Curso>) cursoDao.findByProfesorId(id);
    }
}
