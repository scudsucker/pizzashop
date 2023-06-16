package org.example.calculators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxCalculatorTest {

    // SUT
    private static TaxCalculator taxCalculator;
    private static final double taxRate = 14.5; // In %

    @BeforeAll
    public static void setup() {
        taxCalculator = new TaxCalculator(taxRate);
    }

    @Test
    public void calculateTax_Test() {
        int tax = taxCalculator.getTax(10000);

        assertThat(tax).isEqualTo(1450);

    }

    @Test
    public void calculateTaxOnZero_Test() {
        int tax = taxCalculator.getTax(0);

        assertThat(tax).isEqualTo(0);

    }
}
