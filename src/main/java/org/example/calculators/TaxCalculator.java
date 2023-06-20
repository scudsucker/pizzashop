package org.example.calculators;

import static java.lang.Math.round;
import static java.lang.Math.toIntExact;

public class TaxCalculator {

    private final double taxRate;
    public TaxCalculator(double taxRatePercent) {
        taxRate = taxRatePercent / 100; // convert from % to fraction
    }

    public int getTax(int totalSoFar) {
        return toIntExact(round(totalSoFar * taxRate));
    }
}
