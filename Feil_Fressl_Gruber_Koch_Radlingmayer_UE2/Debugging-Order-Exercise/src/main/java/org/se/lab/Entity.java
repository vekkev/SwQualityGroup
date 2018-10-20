package org.se.lab;

import java.util.Objects;

abstract class Entity {
    /*
     * Property: id:int
     */
    private int id;

    public int getId() {
        return id;
    }

    void setId(int id) {
        if (id < 0)
            throw new IllegalArgumentException();
        this.id = id;
    }


    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entity) {
            return Objects.equals(this.id, ((Entity) obj).id);
        }
        return false;
    }
}
