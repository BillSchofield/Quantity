package org.bill.quantity;

public class Quantity {
    private final Integer amount;
    private final Units units;

    public Quantity(int amount, Units units) {
        this.amount = amount;
        this.units = units;
    }

    public Quantity and(Quantity quantity) {
        return quantity;
    }

    public Quantity as(Units units) {
        return null;
    }

    @Override
    public String toString() {
        return amount.toString() + " " + units.toString();
    }
}
