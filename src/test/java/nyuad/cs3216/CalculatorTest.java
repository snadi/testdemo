package nyuad.cs3216;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    private void initializeCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void divide_WholeDivisible() {
        int a = 12;
        int b = 4;
        double expected = 3;
        assertEquals(expected, calculator.divide(a, b));
    }

    @Test
    public void divide_WholeFraction() {
        int a = 3;
        int b = 4;
        double expected = 0.75;
        assertEquals(expected, calculator.divide(a, b));
    }

    @Test
    public void divide_WithRemainder() {
        int a = 4;
        int b = 3;
        double expected = 1.33333333333;
        assertEquals(expected, calculator.divide(a, b), 0.0000001d);
    }

    @Test
    public void divide_ByZero(){
        assertEquals(Double.POSITIVE_INFINITY, calculator.divide(5, 0));
    }
    

}
