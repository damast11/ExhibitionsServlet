package com.kulishd.entity;


import java.time.LocalDate;
import java.util.Set;

public class Hall {

    private Long id;
    private String name;

    private Set<Exposition> expositions;
    public Hall() {
    }

    public Hall(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Exposition> getExpositions() {
        return expositions;
    }

    public void setExpositions(Set<Exposition> expositions) {
        this.expositions = expositions;
    }

    public boolean hasExposition(Exposition exposition) {
        for (Exposition expositionHall: getExpositions()) {
            if (expositionHall.getId().equals(exposition.getId())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '}';
    }
}
