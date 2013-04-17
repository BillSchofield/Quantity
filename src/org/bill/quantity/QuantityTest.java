package org.bill.quantity;

import org.junit.Test;


import static java.lang.Integer.valueOf;
import static org.bill.quantity.Units.Cup;
import static org.bill.quantity.Units.Teaspoon;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class QuantityTest {

    @Test
    public void toStringShouldIncludeAmountForOne() {
        Quantity quantity = new Quantity(1, Cup);
        assertThat(quantity.toString(), containsString("1"));
    }

    @Test
    public void toStringShouldIncludeAmountForTwo() {
        Quantity quantity = new Quantity(2, Cup);
        assertThat(quantity.toString(), containsString("2"));
    }

    @Test
    public void toStringShouldIncludeUnitsForCups() throws Exception {
        Quantity quantity = new Quantity(1, Cup);
        assertThat(quantity.toString(), containsString("Cup"));
    }

    @Test
    public void toStringShouldIncludeUnitsForTeaspoons() throws Exception {
        Quantity quantity = new Quantity(1, Teaspoon);
        assertThat(quantity.toString(), containsString("Teaspoon"));
    }

    @Test
    public void toStringShouldPrintQuantityThenASpaceThenUnits() throws Exception {
        Quantity quantity = new Quantity(1, Teaspoon);
        String result = quantity.toString();
        assertThat(indexOf(result, "1"), is(lessThan(indexOf(result, " "))));
        assertThat(indexOf(result, " "), is(lessThan(indexOf(result, "Teaspoon"))));
    }

    private Integer indexOf(String result, String substring) {
        return valueOf(result.indexOf(substring));
    }


}
