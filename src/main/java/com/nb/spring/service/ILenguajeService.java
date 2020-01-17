package com.nb.spring.service;

import com.nb.spring.entity.Lenguaje;

import java.util.List;

public interface ILenguajeService {

    public List<Lenguaje> findAll();

    public void saveLenguaje(Lenguaje lenguaje);

    public Lenguaje findLenguajeById(Long id);
}
