package com.foxminded.formatter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FormatterToolsTest {
    
    private FormatterTools tools = new FormatterTools();

    @Test
    public void drawSymbols_shouldReturnEmptyString_whenInputZeroAndSpace() {
        assertEquals("", tools.drawSymbols(0, ' '));
    }

    public void drawSymbols_shouldReturnEmptyString_whenInputZeroAndAsterisk() {
        assertEquals("", tools.drawSymbols(0, '*'));
    }

    @Test
    public void drawSymbols_shouldReturnEmptyString_whenInputZeroAndNullCharacter() {
        assertEquals("", tools.drawSymbols(0, '\u0000'));
    }

    @Test
    public void drawSymbols_shouldReturnEmptyString_whenInputZeroAndNulCharacter() {
        assertEquals("00000", tools.drawSymbols(5, '0'));
    }

    @Test
    public void drawSymbols_shouldReturnOneSpace_whenInputNumberOneAndSymbolSpace() {
        assertEquals(" ", tools.drawSymbols(1, ' '));
    }

    @Test
    public void drawSymbols_shouldReturnFourSpaces_whenInputFourAndSpace() {
        assertEquals("    ", tools.drawSymbols(4, ' '));
    }

    @Test
    public void drawSymbols_shouldReturnOneDash_whenInputOneAndDash() {
        assertEquals("-", tools.drawSymbols(1, '-'));
    }

    @Test
    public void drawSymbols_shouldReturnThreeHyphens_whenInputThreeAndDash() {
        assertEquals("---", tools.drawSymbols(3, '-'));
    }
}
