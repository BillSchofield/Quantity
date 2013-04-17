package org.bill.quantity;

public class Quantity {
    private final Integer amount;

    public Quantity(int amount, Units units) {
        this.amount = amount;
    }

    public Quantity and(Quantity quantity) {
        return quantity;
    }

    public Quantity as(Units units) {
        return null;
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
