package com.foxminded.facade;

import com.foxminded.division.*;
import com.foxminded.formatter.*;

public class CalculatorFacade {
    public String initCalculation(Division division) {
        String result = "";
        if (division.getDividend() < 0) {
            result = "Enter only positive numbers.";
        } else if (division.getDivisor() < 0) {
            result = "Enter only positive numbers.";
        } else if (division.getDividend() < division.getDivisor()) {
            result = division.getDividend() + " divided by " + division.getDivisor() + " is equals 0.";
        } else {
            result = new Formatter(division).formattingResult();
        }
        return result;
    }
}
