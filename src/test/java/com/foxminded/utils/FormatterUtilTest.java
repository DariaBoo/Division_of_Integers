package com.foxminded.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.foxminded.utils.FormatterUtil;

class FormatterUtilTest {   
    private FormatterUtil util = new FormatterUtil();
    
    @ParameterizedTest(name = "{index}. When input symbol ''{1}'' counting {0} times will return result ''{2}''.")
    @CsvSource({
        "0, ' ', ''",
        "0, *, ''",
        "0, '\u0000', ''",
        "5, 0, 00000",
        "1, ' ', ' '",
        "4, ' ', '    '",
        "1, -, -",
        "3, -, ---"
    })
    
    void drawSymbols_shouldReturnStringResult_whenInputCountOfSymbolsAndSymbol(int countOfSymbols, char symbol, String result) {
        assertEquals(result, util.drawSymbols(countOfSymbols, symbol));
    }
}
