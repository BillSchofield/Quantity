package org.bill.quantity;

import org.junit.Test;

import static org.bill.quantity.Units.CUP;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class QuantityTest {

    @Test
    public void toStringShouldIncludeAmountWhenItIsOne() {
        Quantity quantity = new Quantity(1, CUP);
        assertThat(quantity.toString(), containsString("1"));
    }

    @Test
    public void toStringShouldIncludeAmountWhenItIsTwo() {
        Quantity quantity = new Quantity(2, CUP);
        assertThat(quantity.toString(), containsString("2"));
    }
}
