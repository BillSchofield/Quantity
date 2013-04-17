package org.bill.quantity;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.bill.quantity.Units.CUP;
import static org.junit.Assert.assertThat;

public class QuantityTest {

    @Test
    public void testToString() throws Exception {
        Quantity quantity = new Quantity(1, CUP);
        assertThat(quantity.toString(), CoreMatchers.is("1 cup"));
    }

    @Test
    public void testAnd() throws Exception {

    }

    @Test
    public void testAs() throws Exception {

    }
}
