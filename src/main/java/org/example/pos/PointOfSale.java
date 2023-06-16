package org.example.pos;

import org.example.calculators.TaxCalculator;
import org.example.models.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class PointOfSale {

    private TaxCalculator taxCalculator;

    private int runningTotal = 0;

    private final Map<MenuItem, Integer> order = new HashMap<>();

    public PointOfSale(double taxRate) {
        this.taxCalculator = new TaxCalculator(taxRate);
    }

    public int addMenuItem(MenuItem menuItem, int numberOfItems) {

        order.merge(menuItem, numberOfItems, Integer::sum);

        this.runningTotal += menuItem.get_costInCents() * numberOfItems;
        return this.runningTotal;
    }

    public Map<MenuItem, Integer> getOrder() {
        return order;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getTax() {
        return taxCalculator.getTax(runningTotal);
    }

    public int getTotalAfterTax() {
        return runningTotal + taxCalculator.getTax(runningTotal);
    }
}
