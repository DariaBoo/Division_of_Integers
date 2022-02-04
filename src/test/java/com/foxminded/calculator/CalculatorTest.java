package com.foxminded.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.foxminded.division.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private Division division;
    
    @Test
    public void calculate_shouldReturnArithmeticException_WhenInputDivisorZero() {
        division = new Division(25689, 0);
        assertThrows(ArithmeticException.class, () -> calculator.calculate(division),
                "Input divisor zero should throw ArithmeticException.");
    }

    
}
