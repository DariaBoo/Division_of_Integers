package com.foxminded.utils;

public class FormatterUtil {
    
    public String drawSymbols(int countOfSymbols, char symbol) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < countOfSymbols; i++) {
            result.append(symbol);
        }
        return result.toString();
    }

    public int countOfDigits(int n) {

        return (int) Math.log10(n) + 1;
    }
}
