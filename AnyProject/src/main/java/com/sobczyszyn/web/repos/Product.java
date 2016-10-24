package com.sobczyszyn.web.repos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Product() {
    }

    private String shortName;
    private String description;

    public Product(String name) {
        this.shortName = name;
    }

    public Product(String name, String description) {
        this.shortName = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public Product withDescription(String description) {
        setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
