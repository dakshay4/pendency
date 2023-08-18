package com.dakshay.tracking.model;

import lombok.*;

import java.util.List;


public class Entity {
    private int id;
    private List<String> tags;

    public Entity(int id, List<String> tags) {
        this.id = id;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
