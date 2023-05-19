package services;

import models.Examen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import repositories.ExamenRepoOtro;
import repositories.ExamenRepository;
import repositories.ExamenRepositoryImpl;
import repositories.PreguntaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExamenServImplTest {

    ExamenService service;
    ExamenRepository repo;
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp() {
       repo = Mockito.mock(ExamenRepository.class);
       preguntaRepository = Mockito.mock(PreguntaRepository.class);
       service = new ExamenServImpl(repo,preguntaRepository);

    }

    @Test
    void findExamenPorNombre() {

        repo = Mockito.mock(ExamenRepository.class);
        service = new ExamenServImpl(repo);
      List<Examen> datos =  Arrays.asList(new Examen(2L,"Lengua"),
                                          new Examen(3L,"Fisica"),
                                          new Examen(4L,"Geografia"));

      when(repo.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Lengua");

       assertTrue(examen.isPresent());
       assertEquals(2L,examen.orElseThrow().getId());
       assertEquals("Lengua",examen.get().getNombre());

    }

    @Test
    void findExamenPorId(){
        ExamenRepository repository = Mockito.mock(ExamenRepository.class);
        ExamenService    serv = new ExamenServImpl(repository);
        List<Examen> datos =  Arrays.asList(new Examen(1L,"Educacion_fisica"),
                new Examen(3L,"Geometria"),
                new Examen(4L,"Ciencias_sociales"));

        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = serv.findExamenPorNombre("Geometria");

        assertTrue(examen.isPresent());
        assertEquals(3L,examen.orElseThrow().getId());
        assertEquals("Geometria",examen.get().getNombre());



    }

    @Test
    void TestPreguntasExamen() {



    }
}