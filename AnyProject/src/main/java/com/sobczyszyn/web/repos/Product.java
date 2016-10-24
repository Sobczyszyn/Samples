package com.sobczyszyn.web.repos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;

    public Product() {
    }

    private String shortName;
    private String desctiption;

    public Product(int id, String name) {
        this.id = id;
        this.shortName = name;
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

    public String getDesctiption() {
        return desctiption;
    }

    public Product withDescription(String description) {
        setDesctiption(description);
        return this;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }
}
