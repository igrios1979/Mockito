package repositories;

import models.Examen;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepository {
    @Override
    public List<Examen> findAll() {
        return Arrays.asList(new Examen(2L,"Lengua"),
                             new Examen(2L,"Fisica"),
                             new Examen(3L,"Geografia"));
    }



}
