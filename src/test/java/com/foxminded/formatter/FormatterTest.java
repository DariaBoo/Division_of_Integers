package com.foxminded.formatter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.foxminded.division.*;

public class FormatterTest {
    private Division division;
    private Formatter formatter;

    @Test
    public void formattingResult_shouldReturnFormattedString_whenInputCorrectData() {
        division = new Division(258, 3);
        formatter = new Formatter(division);
        String expected = "_258|3\r\n" + " 24 |--\r\n" + " -- |86\r\n" + " _18\r\n" + "  18\r\n" + "  --\r\n"
                + "   0\r\n";

        assertEquals(expected, formatter.formattingResult());
    }

    @Test
    public void formattingResult_shouldReturnFormatedString_whenInputMaxValueIntegerAsDividendAndDivisor() {
        division = new Division(2147483647, 2147483647);
        formatter = new Formatter(division);

        String expected = "_2147483647|2147483647\r\n" + " 2147483647|-\r\n" + " ----------|1\r\n" + "          0\r\n";

        assertEquals(expected, formatter.formattingResult());
    }

    @Test
    public void formattingResult_shouldReturnFormatedString_whenInputThreeDigitDivisor() {
        formatter = new Formatter(new Division(258963, 369));

        String expected = "_258963|369\r\n" + " 2583  |---\r\n" + " ----  |701\r\n" + "   _663\r\n" + "    369\r\n"
                + "    ---\r\n" + "    294\r\n";

        assertEquals(expected, formatter.formattingResult());
    }

    @Test
    public void formattingResult_shouldReturnFormatedString_whenInputMaxValueIntegerAsDividendAndBigDivisor() {
        formatter = new Formatter(new Division(2147483647, 5289604));
        String expected = "_2147483647|5289604\r\n" + " 21158416  |---\r\n" + " --------  |405\r\n" + "  _31642047\r\n"
                + "   26448020\r\n" + "   --------\r\n" + "    5194027\r\n";

        assertEquals(expected, formatter.formattingResult());
    }
}
