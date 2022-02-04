package com.foxminded.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.foxminded.division.*;


public class DataValidatorTest {
    DataValidator validator = new DataValidator();
    Division division;

    @Test
    public void initCalculation_shouldReturnErrorMessage_whenInputNegativeDividend() {     
        division = new Division(-985,3);
        String expected = "Enter only positive numbers.";
        assertEquals(expected, validator.initCalculation(division));
    }
    @Test
    public void initCalculation_shouldReturnErrorMessage_whenInputNegativeDivisor() {     
        division = new Division(985,-3);
        String expected = "Enter only positive numbers.";
        assertEquals(expected, validator.initCalculation(division));
    }
    @Test
    public void initCalculation_shouldReturnErrorMessage_whenInputNegativeDividendAndDivisor() {     
        division = new Division(-985,-3);
        String expected = "Enter only positive numbers.";
        assertEquals(expected, validator.initCalculation(division));
    }
    @Test
    public void initCalculation_shouldReturnErrorMessage_whenInputDividendLessThanDivisor() {     
        division = new Division(3,985);
        String expected = "3 divided by 985 is equals 0.";
        assertEquals(expected, validator.initCalculation(division));
    }
    @Test
    public void initCalculation_shouldReturnErrorMessage_whenInputNegativeDividendLessThanDivisor() {     
        division = new Division(-3,985);
        String expected = "Enter only positive numbers.";
        assertEquals(expected, validator.initCalculation(division));
    }
    @Test
    public void initCalculation_shouldReturnErrorMessage_whenInputDividendLessThanNegativeDivisor() {     
        division = new Division(3,-985);
        String expected = "Enter only positive numbers.";
        assertEquals(expected, validator.initCalculation(division));
    }
    @Test
    public void initCalculation_shouldReturnErrorMessage_whenInputPositiveDividendGreaterThanDivisor() {     
        division = new Division(985,3);
        String expected = "_985|3\r\n"
                + " 9  |---\r\n"
                + " -  |328\r\n"
                + " _8\r\n"
                + "  6\r\n"
                + "  -\r\n"
                + " _25\r\n"
                + "  24\r\n"
                + "  --\r\n"
                + "   1\r\n";
        assertEquals(expected, validator.initCalculation(division));
    }
}
