package com.lowcostairline.beans;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import com.lowcostairline.singleton.IdGenerator;

import java.util.Objects;


public class Entity {
    @JacksonXmlProperty(isAttribute=true)
    private int id = IdGenerator.getNewId();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id: " + id;
    }
}
