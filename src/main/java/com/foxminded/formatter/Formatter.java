package com.foxminded.formatter;

import com.foxminded.calculator.Calculator;
import com.foxminded.division.*;
import com.foxminded.utils.FormatterUtil;

public class Formatter {
    private FormatterUtil util = new FormatterUtil();
    private Calculator calculator = new Calculator();
    private Division division;
    private int resultTempLength;
    private final int indentCorrection = 1; // 1 - means '_' at the beginning

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
            result.append(resultTemp).append("\n");
        }
        return result.toString();
    }

    private String addIndents(Step step) {
        int i = step.getCountOfSymbols() + indentCorrection;
        String result = String.format("%" + i + "s", step.getValue());
        return result;
    }

    private String modifyFirstLine(String resultTemp) {
        StringBuilder result = new StringBuilder(resultTemp);
        int startAfterUnderscore = 1;
        int end = resultTemp.length();
        result.replace(startAfterUnderscore, end, (division.getDividend() + "|" + division.getDivisor()));
        return result.toString();
    }

    private String modifySecondLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp);
        resultTempLength = resultTemp.length();
        int numberOfSpaces = util.countOfDigits(division.getDividend()) + indentCorrection - resultTempLength;
        String spaces = util.drawSymbols(numberOfSpaces, ' ');
        String dashes = util.drawSymbols(quotient.length(), '-');
        result.insert(resultTempLength, spaces + "|" + dashes);
        return result.toString();
    }

    private String modifyThirdLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp);
        resultTempLength = resultTemp.length();
        String spaces = util.drawSymbols(
                (util.countOfDigits(division.getDividend()) + indentCorrection - resultTempLength), ' ');
        result.insert(resultTempLength, spaces + "|" + quotient);
        return result.toString();
    }
}
