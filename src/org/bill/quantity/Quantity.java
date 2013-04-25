package org.bill.quantity;

public class Quantity {
    private final Float amount;
    private final Units units;

    public Quantity(Float amount, Units units) {
        this.amount = amount;
        this.units = units;
    }

    public Quantity and(Quantity that) {
        Units destinationUnits = Units.min(this.units, that.units);
        return this.as(destinationUnits).plus(that.as(destinationUnits));
    }

    private Quantity plus(Quantity that) {
        return new Quantity(this.amount + that.amount, this.units);
    }

    public Quantity as(Units units) {
        Float myAmountInBaseUnits = this.units.toBaseUnits(this.amount);
        Float myAmountInNewUnits = units.fromBaseUnits(myAmountInBaseUnits);
        return new Quantity(myAmountInNewUnits, units);
    }

    @Override
    public String toString() {
        Integer amountAsInteger = amount.intValue();
        String amountAsString = Integer.toString(amountAsInteger);
        if (amountAsInteger.floatValue() != amount){
            amountAsString = Float.toString(amount) ;
        }
        return amountAsString + " " + units.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity that = (Quantity) o;
        return this.toBaseUnits().equals(that.toBaseUnits());
    }

    private Float toBaseUnits() {
        return units.toBaseUnits(amount);  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (units != null ? units.hashCode() : 0);
        return result;
    }
}
