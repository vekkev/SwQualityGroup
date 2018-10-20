package org.se.lab;

class OrderLine
        extends Entity {

    // Constructor

    public OrderLine(int id, int quantity, Product product) {
        setId(id);
        setQuantity(quantity);
        setProduct(product);
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    private Product product;

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    // Object methods

    @Override
    public String toString() {
        return getId() + "," + getQuantity() + "," + getProduct();
    }
}
