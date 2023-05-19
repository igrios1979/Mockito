package services;

import models.Examen;

import java.util.Optional;

public interface ExamenService {

    Optional<Examen> findExamenPorNombre(String nombre);
    Optional <Examen> findPorID(Long id);

    Examen findExamenPorNombreConPreguntas(String nombre);





}
