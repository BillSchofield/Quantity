package org.bill.quantity;

import org.junit.Test;

import static java.lang.Integer.valueOf;
import static org.bill.quantity.Units.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class QuantityTest {

    public static final Quantity oneTeaspoon = new Quantity(1.f, Teaspoon);
    public static final Quantity oneTablespoon = new Quantity(1.f, Tablespoon);
    public static final Quantity sixteenTablespoons = new Quantity(16.f, Tablespoon);
    public static final Quantity oneCup = new Quantity(1.f, Cup);
    public static final Quantity twoCups = new Quantity(2.f, Cup);
    public static final Quantity threeCups = new Quantity(3.f, Cup);
    public static final Quantity fiveCups = new Quantity(5.f, Cup);

    @Test
    public void toStringShouldIncludeAmountForOne() {
        assertThat(oneCup.toString(), containsString("1"));
    }

    @Test
    public void toStringShouldIncludeAmountForTwo() {
        assertThat(twoCups.toString(), containsString("2"));
    }

    @Test
    public void toStringShouldIncludeUnitsForCups() throws Exception {
        assertThat(oneCup.toString(), containsString("Cup"));
    }

    @Test
    public void toStringShouldIncludeUnitsForTeaspoons() throws Exception {
        assertThat(oneTeaspoon.toString(), containsString("Teaspoon"));
    }

    @Test
    public void toStringShouldPrintQuantityThenASpaceThenUnits() throws Exception {
        String result = oneTeaspoon.toString();
        assertThat(indexOf(result, "1"), is(lessThan(indexOf(result, " "))));
        assertThat(indexOf(result, " "), is(lessThan(indexOf(result, "Teaspoon"))));
    }

    @Test
    public void oneCupShouldEqual16Tablespoons(){
        assertThat(oneCup, is(sixteenTablespoons));
    }

    @Test
    public void oneCupShouldNotEqualOneTablespoons(){
        assertThat(oneCup, is(not(oneTablespoon)));
    }

    @Test
    public void shouldConvertOneCupToSixteenTablespoons() {
        assertThat(oneCup.as(Tablespoon).toString(), is(sixteenTablespoons.toString()) );
    }

    @Test
    public void shouldConvertOneTablespoonToOneSixteenthOfACup() {
        assertThat(oneTablespoon.as(Cup).toString(), is("0.0625 Cup") );
    }

    @Test
    public void oneCupAndTwoCupsShouldEqualThreeCups(){
        assertThat(oneCup.and(twoCups), is(threeCups));
    }

    @Test
    public void twoCupsAndThreeCupsShouldEqualFiveCups(){
        assertThat(twoCups.and(threeCups), is(fiveCups));
    }

    @Test
    public void shouldConvertToSmallerUnitsWhenDoingMixedUnitAdditionAndSmallUnitIsFirst(){
        assertThat(oneTeaspoon.and(oneCup).toString(), is("49 Teaspoon"));
    }

    @Test
    public void shouldConvertToSmallerUnitsWhenDoingMixedUnitAdditionAndSmallUnitIsSecond(){
        assertThat(oneCup.and(oneTeaspoon).toString(), is("49 Teaspoon"));
    }

    private Integer indexOf(String result, String substring) {
        return valueOf(result.indexOf(substring));
    }
}
