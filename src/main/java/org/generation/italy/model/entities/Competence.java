package org.generation.italy.model.entities;

public class Competence {
    private long id;
    private String name;
    private String description;
    private Level level;

    public Competence(){

    }
    public Competence(long id, String name, String description, Level level){
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
