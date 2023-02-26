package org.generation.italy.model.services.abstractions;

import org.generation.italy.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.model.entities.Competence;
import org.generation.italy.model.entities.Developer;
import org.generation.italy.model.entities.Level;

import java.util.List;

public interface AbstractSoftwareDevelopService {
    void showSignedDeveloper();
    Developer createDeveloper(Developer developer);
    void updateDeveloperCompetence(Developer developer, Competence competence)throws EntityNotFoundException;
    List<Developer> findDeveloperByStringAndLevel(String x, Level level);
    List<Developer> findDeveloperByNumberCompetence(int numberCompetence);
    List<Developer> findByNumberCompetenceAndLevel(int numberCompetence, String level);
    void showDeveloperCompetence();
    String findDeveloperRangeLevel(String nomeCompetence);
    double salaryMiddleValueDeveloper();
    double maxSalaryDeveloper();
}
