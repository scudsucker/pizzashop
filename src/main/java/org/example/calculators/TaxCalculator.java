package org.example.calculators;

import static java.lang.Math.round;
import static java.lang.Math.toIntExact;

public class TaxCalculator {

    private final double _taxRate;
    public TaxCalculator(double taxRate) {
        _taxRate = taxRate / 100; // convert from % to fraction
    }

    public int getTax(int totalSoFar) {
        return toIntExact(round(totalSoFar * _taxRate));
    }
}
