package org.se.lab;


import java.util.Objects;

class Product
        extends Entity {
    long price;
    String desc;


    public Product(int id, String desc, long price) {
        setId(id);
        setDesc(desc);
        setPrice(price);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        if (desc == null)
            throw new IllegalArgumentException();
        if (desc.trim().equals(""))
            throw new IllegalArgumentException();
        this.desc = desc;
    }


    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }


    // Object methods

    @Override
    public String toString() {
        return getId() + "," + getDesc() + "," + getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.price, this.desc);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) && obj instanceof Product) {
            Product proc = (Product) obj;
            return (this.price == proc.price && this.desc.equals(proc.desc));
        }
        return false;
    }
}
