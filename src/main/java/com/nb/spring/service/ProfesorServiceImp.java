package com.nb.spring.service;

import com.nb.spring.dao.IProfesorDao;
import com.nb.spring.entity.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImp implements IProfesorService {

    @Autowired
    private IProfesorDao profesorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> findAll() {
        return (List<Profesor>) profesorDao.findAll();
    }

    @Override
    @Transactional
    public void save(Profesor profesor) {
        profesorDao.save(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findProfesor(Profesor profesor) {
        return (Profesor) profesorDao.findByEmail(profesor.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor checkProfesorLogin(String email, String password) {
        return (Profesor) profesorDao.findByEmailAndPassword(email, password);
    }

    @Override
    @Transactional
    public void deleteProfesor(Profesor profesor) {
        profesorDao.deleteById(profesor.getId());
    }

    @Override
    @Transactional
    public Profesor updateProfesor(Profesor profesor) {
        return (Profesor) profesorDao.save(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Profesor> findProfesorById(Long profesor_id) {
        return (Optional<Profesor>) profesorDao.findById(profesor_id);
    }

    @Override
    @Transactional
    public void deleteProfesor(Long id) {
        profesorDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllProfesor() {
        profesorDao.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findById(Long id) {
        return profesorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findByIdSQL(Long id) {
        return profesorDao.findByIdSQL(id);
    }
}
