package com.foxminded.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.foxminded.division.*;

class DataValidatorTest {
    private DataValidator validator = new DataValidator();
    private Division division;
    
    @ParameterizedTest(name = "{index}. When input dividend {0} and divisor {1} will return the message: ''{2}''.")
    @CsvSource({
        "-985,3, Enter only positive numbers.",
        "985, -3, Enter only positive numbers.",
        "-985, -3, Enter only positive numbers.",
        "3, 985, 3 divided by 985 is equals 0.",
        "-3, 985, Enter only positive numbers.",
        "3, -985, Enter only positive numbers."
    })
    void initCalculation_shouldReturnErrorMessage_whenInputIncorrectData(int dividend, int divisor, String message) {      
        assertEquals(message, validator.initCalculation(new Division(dividend, divisor)));
    }
    
    @Test
    void initCalculation_shouldReturnCorrectResult_whenInputCorrectData() {
        division = new Division(985, 3);
        String expected = "_985|3\n"
                + " 9  |---\n"
                + " -  |328\n"
                + " _8\n"
                + "  6\n"
                + "  -\n"
                + " _25\n"
                + "  24\n"
                + "  --\n"
                + "   1\n";
        assertEquals(expected, validator.initCalculation(division));
    }
}
