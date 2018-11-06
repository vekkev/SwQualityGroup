package org.se.lab;

public abstract class Entity {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }
}
