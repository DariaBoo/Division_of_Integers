package com.foxminded.divisor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DivisionTest {
    Division division;

    @Test
    public void calculate_shouldReturnArithmeticException_WhenInputDivisorZero() {
        division = new Division(25689, 0);
        assertThrows(ArithmeticException.class, () -> division.calculate(),
                "Input divisor zero should throw ArithmeticException.");
    }

    @Test
    public void calculate_shouldReturnErrorMessage_WhenInputDividendLessThanDivisor() {
        division = new Division(25, 968);
        assertEquals("25 divided by 968 is equals 0.", division.calculate());
    }

    @Test
    public void calculate_shouldReturnErrorMessage_WhenInputDividendZero() {
        division = new Division(0, 369);
        assertEquals("0 divided by 369 is equals 0.", division.calculate());
    }

    @Test
    public void calculate_shouldReturnQuotionWithZeroInTheMiddle_whenInputDividendAndDivisor() {
        division = new Division(720024, 8);
        String expected = "_720024|8\r\n" + " 72    |-----\r\n" + " --    |90003\r\n" + "    _24\r\n" + "     24\r\n"
                + "     --\r\n" + "      0\r\n";
        assertEquals(expected, division.calculate());
    }

    @Test
    public void calculate_shouldReturnCorrectQuotient_whenInputDividendWithFewZeroInTheMiddle() {
        division = new Division(390000000, 5);
        String expected = "_390000000|5\r\n" + " 35       |--------\r\n" + " --       |78000000\r\n" + " _40\r\n"
                + "  40\r\n" + "  --\r\n" + "         0\r\n";
        assertEquals(expected, division.calculate());
    }

    @Test
    public void calculate_shouldReturnCorrectString_whenInputDividendAndDivisorEqual() {
        division = new Division(25, 25);
        String expected = "_25|25\r\n" + " 25|-\r\n" + " --|1\r\n" + "  0\r\n";
        assertEquals(expected, division.calculate());
    }
}
