package com.foxminded.formatter;

import com.foxminded.calculator.Calculator;
import com.foxminded.division.*;

public class Formatter {
    private FormatterTools tools = new FormatterTools();
    private Calculator calculator = new Calculator();
    private Division division;
    private final int LINEFEED = 2; // 2 - means '%n' in the end of resultTemp string from addIndents() method
    private final int UNDERSCORE = 1; // 1 - means '_' at the beginning
    private int beforeLineFeed;

    public Formatter(Division division) {
        this.division = division;
    }

    public String formattingResult() {
        calculator.calculate(division);
        StringBuilder result = new StringBuilder();
        String resultTemp;
        for (int i = 0; i < division.getDivisionSteps().size(); i++) {
            resultTemp = addIndents(division.getDivisionSteps().get(i));
            if (i == 0) {
                resultTemp = modifyFirstLine(resultTemp);
            } else if (i == 1) {
                resultTemp = modifySecondLine(resultTemp, division.getQuotient());

            } else if (i == 2) {
                resultTemp = modifyThirdLine(resultTemp, division.getQuotient());
            }
            result.append(resultTemp);
        }
        return result.toString();
    }

    private String addIndents(Step step) {
        int additionalSpaceInsteadOfUnderscoreInAFirstLine = 1;
        int i = step.getCountOfSymbols() + additionalSpaceInsteadOfUnderscoreInAFirstLine;
        String result = String.format("%" + i + "s%n", step.getValue());
        return result;
    }

    private String modifyFirstLine(String resultTemp) {
        StringBuilder result = new StringBuilder(resultTemp);
        int afterUnderscore = 1;
        beforeLineFeed = resultTemp.length() - LINEFEED;
        result.replace(afterUnderscore, beforeLineFeed, (division.getDividend() + "|" + division.getDivisor()));
        return result.toString();
    }

    private String modifySecondLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp);
        int numberOfSpaces = tools.countOfDigits(division.getDividend()) + UNDERSCORE
                - (resultTemp.length() - LINEFEED);
        String spaces = tools.drawSymbols(numberOfSpaces, ' ');
        String dashes = tools.drawSymbols(quotient.length(), '-');
        beforeLineFeed = resultTemp.length() - LINEFEED;
        result.insert(beforeLineFeed, spaces + "|" + dashes);
        return result.toString();
    }

    private String modifyThirdLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp);
        String spaces = tools.drawSymbols(
                (tools.countOfDigits(division.getDividend()) + UNDERSCORE - (resultTemp.length() - LINEFEED)), ' ');
        beforeLineFeed = resultTemp.length() - LINEFEED;
        result.insert(beforeLineFeed, spaces + "|" + quotient);
        return result.toString();
    }
}
