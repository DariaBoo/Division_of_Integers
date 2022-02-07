package com.foxminded.formatter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.foxminded.division.*;

class FormatterTest {
    private Division division;
    private Formatter formatter;

    @Test
    void formattingResult_shouldReturnFormattedString_whenInputCorrectData() {
        division = new Division(258, 3);
        formatter = new Formatter(division);
        String expected = "_258|3\n"
                + " 24 |--\n"
                + " -- |86\n"
                + " _18\n"
                + "  18\n"
                + "  --\n"
                + "   0\n";

        assertEquals(expected, formatter.formattingResult());
    }

   @Test
    void formattingResult_shouldReturnFormatedString_whenInputMaxValueIntegerAsDividendAndDivisor() {
        division = new Division(2147483647, 2147483647);
        formatter = new Formatter(division);

        String expected = "_2147483647|2147483647\n"
                + " 2147483647|-\n"
                + " ----------|1\n"
                + "          0\n";

        assertEquals(expected, formatter.formattingResult());
    }

    @Test
    void formattingResult_shouldReturnFormatedString_whenInputThreeDigitDivisor() {
        formatter = new Formatter(new Division(258963, 369));

        String expected = "_258963|369\n"
                + " 2583  |---\n"
                + " ----  |701\n"
                + "   _663\n"
                + "    369\n"
                + "    ---\n"
                + "    294\n";

        assertEquals(expected, formatter.formattingResult());
    }
  
    @Test
    void formattingResult_shouldReturnFormatedString_whenInputMaxValueIntegerAsDividendAndBigDivisor() {
        formatter = new Formatter(new Division(2147483647, 5289604));
        String expected = "_2147483647|5289604\n"
                + " 21158416  |---\n"
                + " --------  |405\n"
                + "  _31642047\n"
                + "   26448020\n"
                + "   --------\n"
                + "    5194027\n";

        assertEquals(expected, formatter.formattingResult());
    } 
}
