package services;

import models.Examen;
import repositories.ExamenRepository;
import repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServImpl implements ExamenService {

    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
        this.examenRepository = examenRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll().stream()
                .filter(a -> a.getNombre()
                        .contains(nombre))
                        .findFirst();
    }

    @Override
    public Optional<Examen> findPorID(Long id) {
        return examenRepository.findAll().stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        return findExamenPorNombre(nombre).map(examen -> {
            List<String> preguntas = preguntaRepository.findPreguntasPorExamen(examen.getId());
            examen.setPreguntas(preguntas);
            return examen;
        }).orElse(null);
    }


}
