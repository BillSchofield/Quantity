package org.bill.quantity;

public class Quantity {
    public Quantity(int amount, Units units) {
    }

    public Quantity and(Quantity quantity) {
        return quantity;
    }

    public Quantity as(Units units) {
        return null;
    }

    @Override
    public String toString() {
        return "1 cup";
    }
}
