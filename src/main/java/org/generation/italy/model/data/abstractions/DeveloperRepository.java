package org.generation.italy.model.data.abstractions;

import org.generation.italy.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.model.entities.Competence;
import org.generation.italy.model.entities.Developer;
import org.generation.italy.model.entities.Level;

import java.util.List;
import java.util.Optional;

public interface DeveloperRepository {
    Optional<Developer> findById(long id);
    void showSigned();
    Developer create(Developer developer);
    void updateCompetence(Developer developer, Competence competence) throws EntityNotFoundException;
    List<Developer> findByStringAndLevel(String x, Level level);
    List<Developer> findByNumberCompetence(int numberCompetence);
    List<Developer> findByNumberCompetenceAndLevel(int numberCompetence, String level);
    void showCompetence();
    String findRangeLevel(String nomeCompetence);
    double salaryMiddleValue();
    double maxSalary(); //punto 9
}
