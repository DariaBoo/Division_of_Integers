package com.foxminded.formatter;

import com.foxminded.calculator.Calculator;
import com.foxminded.division.*;

public class Formatter {
    private FormatterTools tools = new FormatterTools();
    private Division division;
    Calculator calculator = new Calculator();

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
        int i = step.getCountOfSpaces() + 2; // 2 - adding one space at the beginning (input number length is minimum
                                             // 1);
        String result = String.format("%" + i + "s%n", step.getValue());
        return result;
    }

    private String modifyFirstLine(String resultTemp) {
        StringBuilder result = new StringBuilder(resultTemp);
        int end = resultTemp.length() - 2;
        result.replace(1, end, (division.getDividend() + "|" + division.getDivisor()));// 2 - means '/n' in the end of resultTemp string from addIndents() method                                                                                                                                                                           
        return result.toString();
    }

    private String modifySecondLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp); 
        int numberOfSpaces = tools.countOfDigits(division.getDividend()) + 1 - (resultTemp.length() - 2);// (1 - means '_' at the beginning) 2 - means '/n' in the end of resultTemp string from addIndents() method                                 
        String spaces = tools.drawSymbols(numberOfSpaces, ' ');
        String dashes = tools.drawSymbols(quotient.length(), '-');
        result.insert(resultTemp.length() - 2, spaces + "|" + dashes);
        return result.toString();
    }

    private String modifyThirdLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp);
        String spaces = tools.drawSymbols((tools.countOfDigits(division.getDividend()) + 1 - (resultTemp.length() - 2)),
                ' ');
        result.insert((resultTemp.length() - 2), spaces + "|" + quotient);
        return result.toString();
    }
}
