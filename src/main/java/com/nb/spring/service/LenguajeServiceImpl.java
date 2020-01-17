package com.nb.spring.service;

import com.nb.spring.dao.ILenguajeDao;
import com.nb.spring.entity.Lenguaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LenguajeServiceImpl implements ILenguajeService {

    @Autowired
    private ILenguajeDao lenguajeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Lenguaje> findAll() {
        return (List<Lenguaje>) lenguajeDao.findAll();
    }

    @Override
    @Transactional
    public void saveLenguaje(Lenguaje lenguaje) {
        lenguajeDao.save(lenguaje);
    }

    @Override
    @Transactional(readOnly = true)
    public Lenguaje findLenguajeById(Long id) {
        return lenguajeDao.findByIdSQL(id);
    }
}
