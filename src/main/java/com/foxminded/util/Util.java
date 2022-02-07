package com.foxminded.util;

public class Util {
    
    public String createSymbols(int countOfSymbols, char symbol) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < countOfSymbols; i++) {
            result.append(symbol);
        }
        return result.toString();
    }
}
