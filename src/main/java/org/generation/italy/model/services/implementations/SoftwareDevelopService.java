package org.generation.italy.model.services.implementations;

import org.generation.italy.model.data.abstractions.DeveloperRepository;
import org.generation.italy.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.model.entities.Competence;
import org.generation.italy.model.entities.Developer;
import org.generation.italy.model.entities.Level;
import org.generation.italy.model.services.abstractions.AbstractSoftwareDevelopService;

import java.util.List;

public class SoftwareDevelopService implements AbstractSoftwareDevelopService {
    private DeveloperRepository repo;

    public SoftwareDevelopService(DeveloperRepository repo){
        this.repo = repo;
    }


    @Override
    public void showSignedDeveloper() {
        repo.showSigned();
    }

    @Override
    public Developer createDeveloper(Developer developer) {
        return repo.create(developer);
    }

    @Override
    public void updateDeveloperCompetence(Developer developer, Competence competence) throws EntityNotFoundException {
        repo.updateCompetence(developer, competence);
    }

    @Override
    public List<Developer> findDeveloperByStringAndLevel(String x, Level level) {
        return repo.findByStringAndLevel(x, level);
    }

    @Override
    public List<Developer> findDeveloperByNumberCompetence(int numberCompetence) {
        return repo.findByNumberCompetence(numberCompetence);
    }

    @Override
    public List<Developer> findByNumberCompetenceAndLevel(int numberCompetence, String level) {
        return repo.findByNumberCompetenceAndLevel(numberCompetence, level);
    }

    @Override
    public void showDeveloperCompetence() {
        repo.showCompetence();
    }

    @Override
    public String findDeveloperRangeLevel(String nomeCompetence) {
        return repo.findRangeLevel(nomeCompetence);
    }

    @Override
    public double salaryMiddleValueDeveloper() {
        return repo.salaryMiddleValue();
    }

    @Override
    public double maxSalaryDeveloper() {
        return repo.maxSalary();
    }
}
