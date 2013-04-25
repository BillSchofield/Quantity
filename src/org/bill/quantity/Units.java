package org.bill.quantity;

public enum Units implements Comparable<Units>{
    Teaspoon(1.f), Tablespoon(3.f), Cup(48.f);
    private Float multiplier;

    private Units(Float multiplier) {
        this.multiplier = multiplier;
    }

    public Float toBaseUnits(Float amount) {
        return amount * multiplier;
    }

    public Float fromBaseUnits(Float amount) {
        return amount / multiplier;
    }

    public static Units min(Units units1, Units units2) {
        if (units1.multiplier < units2.multiplier){
            return units1;
        }
        return units2;
    }
}
