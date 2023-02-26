package org.generation.italy.model.entities;

import java.time.LocalDate;
import java.util.List;

public class Developer {
    private long id;
    private String firstname;
    private String lastname;
    private char sex;
    private LocalDate hireDate;
    private double salary;
    private String grade;
    private List<Competence> listCompetences;

    public Developer(){

    }
    public Developer(long id, String firstname, String lastname, char sex, LocalDate hireDate, double salary, String grade, List<Competence> listCompetences){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.hireDate = hireDate;
        this.salary = salary;
        this.grade = grade;
        this.listCompetences = listCompetences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Competence> getListCompetences() {
        return listCompetences;
    }

    public void setListCompetences(List<Competence> listCompetences) {
        this.listCompetences = listCompetences;
    }
}
