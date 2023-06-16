package org.example.pos;

import org.example.models.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PointOfSaleTest {

    // SUT
    private static PointOfSale pos;

    private static final MenuItem pizza = new MenuItem("pizza", 10000);
    private static final MenuItem beer = new MenuItem("beer", 4750);
    private static final MenuItem water = new MenuItem("water", 0);

    private static final double taxRate = 14.5; // In %

    @BeforeEach
    public void setup() {
        pos = new PointOfSale(taxRate);
    }

    @Test
    public void addOnePizza_Test() {

        int totalSoFar = pos.addMenuItem(pizza, 1);
        Map<MenuItem, Integer> ordersSoFar = pos.getOrder();

        assertThat(totalSoFar).isEqualTo(10000);
        assertThat(ordersSoFar.containsKey(pizza)).isTrue();
        assertThat(ordersSoFar.get(pizza)).isEqualTo(1);
    }

    @Test
    public void addTwoPizzas_Test() {
        int totalSoFar = pos.addMenuItem(pizza, 2);
        Map<MenuItem, Integer> ordersSoFar = pos.getOrder();

        assertThat(totalSoFar).isEqualTo(20000);
        assertThat(ordersSoFar.containsKey(pizza)).isTrue();
        assertThat(ordersSoFar.get(pizza)).isEqualTo(2);
    }

    @Test
    public void addOneWater_Test() {

        int totalSoFar = pos.addMenuItem(water, 1);
        Map<MenuItem, Integer> ordersSoFar = pos.getOrder();

        assertThat(totalSoFar).isEqualTo(0);
        assertThat(ordersSoFar.containsKey(water)).isTrue();
        assertThat(ordersSoFar.get(water)).isEqualTo(1);
    }
    @Test
    public void addTwoDifferentProducts_Test() {
        pos.addMenuItem(pizza, 1);
        int totalSoFar = pos.addMenuItem(beer, 1);

        Map<MenuItem, Integer> ordersSoFar = pos.getOrder();

        assertThat(totalSoFar).isEqualTo(14750);
        assertThat(ordersSoFar.containsKey(pizza)).isTrue();
        assertThat(ordersSoFar.containsKey(beer)).isTrue();
        assertThat(ordersSoFar.get(pizza)).isEqualTo(1);
        assertThat(ordersSoFar.get(beer)).isEqualTo(1);
    }

    @Test
    public void addTheSameProductTwice_Test() {
        pos.addMenuItem(pizza, 1);
        int totalSoFar = pos.addMenuItem(pizza, 1);

        Map<MenuItem, Integer> ordersSoFar = pos.getOrder();

        assertThat(totalSoFar).isEqualTo(20000);
        assertThat(ordersSoFar.containsKey(pizza)).isTrue();
        assertThat(ordersSoFar.get(pizza)).isEqualTo(2);
    }

    @Test
    public void getTheBill_Test() {
        int totalBeforeTax = pos.addMenuItem(pizza, 1);

        int tax = pos.getTax();
        int totalAfterTax = pos.getTotalAfterTax();

        assertThat(totalBeforeTax).isEqualTo(10000);
        assertThat(tax).isEqualTo(1450);
        assertThat(totalAfterTax).isEqualTo(11450);
    }

    @Test
    public void getAMoreComplexBill_Test() {
        pos.addMenuItem(pizza, 1);
        int totalBeforeTax = pos.addMenuItem(beer, 1);

        int tax = pos.getTax();
        int totalAfterTax = pos.getTotalAfterTax();

        assertThat(totalBeforeTax).isEqualTo(14750);
        assertThat(tax).isEqualTo(2139);
        assertThat(totalAfterTax).isEqualTo(16889);
    }

    @Test
    public void getZeroValueBill_Test() {

        int totalBeforeTax = pos.addMenuItem(water, 1);

        int tax = pos.getTax();
        int totalAfterTax = pos.getTotalAfterTax();

        assertThat(totalBeforeTax).isEqualTo(0);
        assertThat(tax).isEqualTo(0);
        assertThat(totalAfterTax).isEqualTo(0);
    }

}
