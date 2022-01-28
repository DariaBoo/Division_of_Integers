package com.foxminded.formatter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import com.foxminded.divisor.*;

public class FormatterTest {
    Formatter formatter;

    @Test
    public void formattingResult_shouldReturnFormatedString_whenInputListOfStepsAndQuotient() {
        formatter = new Formatter(85221034, 2);

        List<Step> list = new ArrayList<>();
        list.add(new Step("_852", 2));
        list.add(new Step("777", 2));
        list.add(new Step("---", 2));
        list.add(new Step("_752", 3));
        list.add(new Step("518", 3));
        list.add(new Step("---", 3));
        list.add(new Step("_2341", 4));
        list.add(new Step("2331", 4));
        list.add(new Step("----", 4));
        list.add(new Step("_1003", 5));
        list.add(new Step("777", 5));
        list.add(new Step("---", 5));
        list.add(new Step("_2264", 6));
        list.add(new Step("2072", 6));
        list.add(new Step("----", 6));
        list.add(new Step("192", 6));

        String expected = "_85221034|2\r\n"
                + " 777     |------\r\n"
                + " ---     |329038\r\n"
                + " _752\r\n"
                + "  518\r\n"
                + "  ---\r\n"
                + " _2341\r\n"
                + "  2331\r\n"
                + "  ----\r\n"
                + "  _1003\r\n"
                + "    777\r\n"
                + "    ---\r\n"
                + "   _2264\r\n"
                + "    2072\r\n"
                + "    ----\r\n"
                + "     192\r\n";
        assertEquals(expected, formatter.formattingResult(list, "329038"));
    }
    
    @Test
    public void formattingResult_shouldReturnFormatedString_whenInputThreeDigitDivisor() {
        formatter = new Formatter(258963, 369);

        List<Step> list = new ArrayList<>();
        list.add(new Step("_2589", 3));
        list.add(new Step("2583", 3));
        list.add(new Step("----", 3));
        list.add(new Step("_663", 5));
        list.add(new Step("369", 5));
        list.add(new Step("---", 5));
        list.add(new Step("294", 5));

        String expected = "_258963|369\r\n"
                + " 2583  |---\r\n"
                + " ----  |701\r\n"
                + "   _663\r\n"
                + "    369\r\n"
                + "    ---\r\n"
                + "    294\r\n";

        assertEquals(expected, formatter.formattingResult(list, "701"));
    }
    
    @Test
    public void formattingResult_shouldReturnFormatedString_whenInputMaxValueIntegerAsDividend() {
        formatter = new Formatter(2147483647, 5289604);

        List<Step> list = new ArrayList<>();
        list.add(new Step("_21474836", 7));
        list.add(new Step("21158416", 7));
        list.add(new Step("--------", 7));
        list.add(new Step("_31642047", 9));
        list.add(new Step("26448020", 9));
        list.add(new Step("--------", 9));
        list.add(new Step("5194027", 9));

        String expected = "_2147483647|5289604\r\n"
                + " 21158416  |---\r\n"
                + " --------  |405\r\n"
                + "  _31642047\r\n"
                + "   26448020\r\n"
                + "   --------\r\n"
                + "    5194027\r\n";

        assertEquals(expected, formatter.formattingResult(list, "405"));
    }
    
    @Test
    public void formattingResult_shouldReturnFormatedString_whenInputMaxValueIntegerAsDividendAndDivisor() {
        formatter = new Formatter(2147483647, 2147483647);

        List<Step> list = new ArrayList<>();
        list.add(new Step("_2147483647", 9));
        list.add(new Step("2147483647", 9));
        list.add(new Step("----------", 9));
        list.add(new Step("0", 9));

        String expected = "_2147483647|2147483647\r\n"
                + " 2147483647|-\r\n"
                + " ----------|1\r\n"
                + "          0\r\n";

        assertEquals(expected, formatter.formattingResult(list, "1"));
    }
}
