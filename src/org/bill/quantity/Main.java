package org.bill.quantity;

public class Main {

    public static void main(String[] args) {
	    Quantity result = new Quantity(1, Units.CUP).and(new Quantity(2, Units.Tablespoon)).as(Units.Teaspoon);
        System.out.println(result.toString());
    }
}
