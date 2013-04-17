package org.bill.quantity;

public class Main {

    public static void main(String[] args) {
        Quantity result1 = new Quantity(1, Units.Cup).as(Units.Teaspoon);
           System.out.println(result1.toString());
        Quantity result2 = new Quantity(1, Units.Cup).and(new Quantity(2, Units.Tablespoon)).as(Units.Teaspoon);
           System.out.println(result2.toString());
    }
}
