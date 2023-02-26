package org.generation.italy.model.view;

import org.generation.italy.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.model.entities.Competence;
import org.generation.italy.model.entities.Developer;
import org.generation.italy.model.entities.Level;
import org.generation.italy.model.services.abstractions.AbstractSoftwareDevelopService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceConsole {

    private AbstractSoftwareDevelopService service;
    private Scanner console = new Scanner(System.in);
    public UserInterfaceConsole(AbstractSoftwareDevelopService service){
        this.service = service;
    }
    public void userInteraction(){
        welcome();
        char a = console.nextLine().charAt(0);
        while(a != 'f'){
            switch (a){
                case 'a':
                    mostraDev();
                    break;
                case 'b':
                    creaDev();
                    break;
                case 'c':
                    trovaDevs();
                    break;
                case'd':
                    salarioMedioDevs();
                    break;
                case 'e':
                    maxSalarioDevs();
                    break;
                default:
                    System.out.println("\n Non esiste un opzione con questa lettera!\n");
                    break;
            }
            welcome();
            a = console.nextLine().charAt(0);
        }
    }
    public void welcome(){
        System.out.println("Benvenuto all'interfaccia, premi:\na per mostrare gli sviluppatori \n" +
                "b per aggiungere un nuovo sviluppatore \nc per cercare uno sviluppatore grazie ad " +
                "una stringa e un livello\nd per sapere il salario medio\ne per sapere il salario " +
                "piú grande\nf per uscire dal programma");
    }
    private void mostraDev(){
        System.out.println("Ecco gli sviluppatori:\n");
        service.showSignedDeveloper();
        System.out.println("fatto");
    }
    private void creaDev(){
        long id = 0;
        List<Competence> competenceList = null;
        System.out.println("Inserisci il nome:");
        String firstname = console.nextLine();
        System.out.println("Inserisci il cognome:");
        String lastname = console.nextLine();
        System.out.println("Inserisci se maschio (m) o femmina (f):");
        char sex = console.nextLine().charAt(0);
        System.out.println("Inserisci il salario:");
        String slary = console.nextLine();
        double salary = Double.parseDouble(slary);
        System.out.println("Inserisci il titolo:");
        String grade = console.nextLine();
        Developer d = new Developer(id, firstname, lastname, sex, LocalDate.now(), salary, grade, competenceList);
        System.out.println("Vuoi inserire delle competenze?");
        String risposta = console.nextLine();
        if(risposta.equalsIgnoreCase("si")){
            System.out.println("Inserisci il nome della competenza:");
            String name = console.nextLine();
            System.out.println("Inserisci la descrizione della competenza:");
            String description = console.nextLine();
            System.out.println("A che livello é questa competenza? BASIC, INTERMEDIATE, ADVANCE, GURU, GODLY?");
            String level = console.nextLine();
            if (level.equalsIgnoreCase("basic")){
                Level lvl = Level.BASIC;
                Competence c = new Competence(0,name, description, lvl);
            }
            if (level.equalsIgnoreCase("intermediate")){
                Level lvl = Level.INTERMEDIATE;
                Competence c = new Competence(0,name, description, lvl);
                try {
                    service.updateDeveloperCompetence(d, c);
                } catch (EntityNotFoundException e) {
                    System.out.println("Il developer non è stato trovato");
                }
            }
            if (level.equalsIgnoreCase("advance")){
                Level lvl = Level.ADVANCE;
                Competence c = new Competence(0,name, description, lvl);
                try {
                    service.updateDeveloperCompetence(d, c);
                } catch (EntityNotFoundException e) {
                    System.out.println("Il developer non è stato trovato");
                }
            }
            if (level.equalsIgnoreCase("guru")){
                Level lvl = Level.GURU;
                Competence c = new Competence(0,name, description, lvl);
                try {
                    service.updateDeveloperCompetence(d, c);
                } catch (EntityNotFoundException e) {
                    System.out.println("Il developer non è stato trovato");
                }
            }
            if (level.equalsIgnoreCase("godly")){
                Level lvl = Level.GODLY;
                Competence c = new Competence(0,name, description, lvl);
                try {
                    service.updateDeveloperCompetence(d, c);
                } catch (EntityNotFoundException e) {
                    System.out.println("Il developer non è stato trovato");
                }
            }
        }
        System.out.println("Developer creato!");
    }
    private void trovaDevs(){
        System.out.println("Inserisci una stringa: ");
        String part = console.nextLine();
        System.out.println("Inserisci un livello tra: BASIC, INTERMEDIATE, ADVANCE, GURU, GODLY?");
        String risposta = console.nextLine();
        if (risposta.equalsIgnoreCase("basic")){
            Level level = Level.BASIC;
            List<Developer> devs = service.findDeveloperByStringAndLevel(part, level);
            System.out.println("Ecco:" + devs);
        }
        if (risposta.equalsIgnoreCase("intermediate")){
            Level level = Level.INTERMEDIATE;
            List<Developer> devs = service.findDeveloperByStringAndLevel(part, level);
            System.out.println("Ecco:" + devs);
        }
        if (risposta.equalsIgnoreCase("advance")){
            Level level = Level.ADVANCE;
            List<Developer> devs = service.findDeveloperByStringAndLevel(part, level);
            System.out.println("Ecco:" + devs);
        }
        if (risposta.equalsIgnoreCase("guru")){
            Level level = Level.GURU;
            List<Developer> devs = service.findDeveloperByStringAndLevel(part, level);
            System.out.println("Ecco:" + devs);
        }
        if (risposta.equalsIgnoreCase("godly")){
            Level level = Level.GODLY;
            List<Developer> devs = service.findDeveloperByStringAndLevel(part, level);
            System.out.println("Ecco:" + devs);
        }
    }
    private void salarioMedioDevs(){
        System.out.println("Ecco il salario medio: " + service.salaryMiddleValueDeveloper());
    }
    private void maxSalarioDevs(){
        System.out.println("Ecco il salario piú grande: " + service.maxSalaryDeveloper());
    }
}
