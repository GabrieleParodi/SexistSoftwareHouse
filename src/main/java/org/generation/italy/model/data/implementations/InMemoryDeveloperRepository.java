package org.generation.italy.model.data.implementations;

import org.generation.italy.model.data.abstractions.DeveloperRepository;
import org.generation.italy.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.model.entities.Competence;
import org.generation.italy.model.entities.Developer;
import org.generation.italy.model.entities.Level;

import java.util.*;

public class InMemoryDeveloperRepository implements DeveloperRepository {

    private static Map<Long, Developer> datasource = new HashMap<>();
    private static long nextId;

    @Override
    public Optional<Developer> findById(long id) {
        Developer x = datasource.get(id);
        if(x != null){
            return Optional.of(x);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void showSigned() {
        datasource.values().stream()
                .forEach(d -> System.out.println("Nome: " + d.getFirstname() + " Cognome: " + d.getLastname() + " Grado: " + d.getGrade() + " Numero di linguaggi conosciuti: " + d.getListCompetences().size()));
    }

    @Override
    public Developer create(Developer developer) {
        nextId++;
        datasource.put(nextId, developer);
        developer.setId(nextId);
        return developer;
    }

    @Override
    public void updateCompetence(Developer developer, Competence competence) throws EntityNotFoundException{
        if(datasource.containsKey(developer.getId())){
            developer.getListCompetences().add(competence);
        }else {
            throw new EntityNotFoundException("Nessun developer trovato");
        }
    }

    @Override
    public List<Developer> findByStringAndLevel(String x, Level level) {
        return datasource.values().stream().filter(d -> d.getListCompetences().contains(x) && d.getListCompetences().contains(level)).toList();
    }

    @Override
    public List<Developer> findByNumberCompetence(int numberCompetence) {
        return datasource.values().stream().filter(d -> d.getListCompetences().size() >= numberCompetence).toList();
    }

    @Override
    public List<Developer> findByNumberCompetenceAndLevel(int numberCompetence, String level) {
//        List<Developer> devs = datasource.values().stream()
//                .filter(d -> (d.getListCompetences().size() >= numberCompetence))
//                .filter(l -> l.getListCompetences().stream().filter(c -> Level.valueOf(c.getLevel().toString()).ordinal() >= Level.valueOf(level).ordinal()).toList();
        //Level.valueOf(d.getLevel).ordinal >= Level.valueOf(level).ordinal()

    return null;
    }

    @Override
    public void showCompetence() {
//        datasource.values().stream().map(Developer::getListCompetences).forEach(c -> System.out.println(c.getName));
    }


    @Override
    public String findRangeLevel(String nomeCompetence) {
        return null;
    }

    @Override
    public double salaryMiddleValue() {
        return datasource.values().stream().mapToDouble(Developer::getSalary).sum()/ datasource.size();
    }

    @Override
    public double maxSalary() {
        return datasource.values().stream().sorted(Comparator.comparingDouble(Developer::getSalary)).toList().get(0).getSalary();
    }
}
