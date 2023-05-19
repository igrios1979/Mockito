package repositories;

import models.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepoOtro implements ExamenRepository{


    @Override
    public List<Examen> findAll() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
