package com.example.leet.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void postFixWithSpaceCalculatorNullReturnsZero(){
        int response = Calculator.postFixWithSpaceCalculator(null);

        assertEquals(response, 0);
    }

    @Test
    public void postFixWithSpaceCalculatorTwoValuesReturnsZero(){
        int response = Calculator.postFixWithSpaceCalculator("23 *");

        assertEquals(response, 0);
    }

    @Test
    public void postFixWithSpaceCalculatorTwoValuesReturnsZero2(){
        int response = Calculator.postFixWithSpaceCalculator("23 23");

        assertEquals(response, 0);
    }

    @Test
    public void postFixWithSpaceCalculatorFourValuesReturnsZero(){
        int response = Calculator.postFixWithSpaceCalculator("23 23 * *");

        assertEquals(response, 0);
    }

    @Test
    public void postFixWithSpaceCalculator3ValuesReturnsMultiplication(){
        int response = Calculator.postFixWithSpaceCalculator("23 23 *");

        assertEquals(response, 23*23);
    }

    @Test
    public void postFixWithSpaceCalculator3ValuesReturnsDivision(){
        int response = Calculator.postFixWithSpaceCalculator("23 23 /");

        assertEquals(response, 1);
    }

    @Test
    public void postFixWithSpaceCalculator3ValuesReturnsAddition(){
        int response = Calculator.postFixWithSpaceCalculator("23 23 +");

        assertEquals(response, 46);
    }

    @Test
    public void postFixWithSpaceCalculator3ValuesReturnsSubstract(){
        int response = Calculator.postFixWithSpaceCalculator("23 23 -");

        assertEquals(response, 0);
    }

    @Test
    public void test(){
        assertEquals(Calculator.postfixNoSeparation("12+"), 3);
    }
}