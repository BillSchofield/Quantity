package org.bill.quantity;

public class Main {

    public static void main(String[] args) {
        Quantity result1 = new Quantity(1.f, Units.Cup).as(Units.Teaspoon);
        System.out.println(result1.toString());
        Quantity result2 = new Quantity(1.f, Units.Teaspoon).as(Units.Cup);
        System.out.println(result2.toString());
        Quantity result3 = new Quantity(1.f, Units.Cup).and(new Quantity(2.f, Units.Tablespoon));
        System.out.println(result3.toString());
    }
}
