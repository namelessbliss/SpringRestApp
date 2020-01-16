package com.nb.spring.mapper;

import com.nb.spring.entity.Profesor;
import com.nb.spring.model.MProfesor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("mapper")
public class Mapper {

    public static List<MProfesor> convertirLista(List<Profesor> profesores) {
        List<MProfesor> mProfesores = new ArrayList<>();
        for (Profesor profesor : profesores) {
            mProfesores.add(new MProfesor(profesor));
        }
        return mProfesores;
    }
}
