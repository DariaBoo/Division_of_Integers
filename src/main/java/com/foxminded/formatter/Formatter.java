package com.foxminded.formatter;

import java.util.List;
import com.foxminded.divisor.*;

public class Formatter {
    private int dividend;
    private int divisor;
    private FormatterTools tools = new FormatterTools();

    public Formatter(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public String formattingResult(List<Step> divisionSteps, String quotient) {
        StringBuilder result = new StringBuilder();
        String resultTemp;
        for (int i = 0; i < divisionSteps.size(); i++) {
            resultTemp = addIndents(divisionSteps.get(i));
            switch (i) {
            case 0:
                resultTemp = modifyFirstLine(resultTemp);
                break;
            case 1:
                resultTemp = modifySecondLine(resultTemp, quotient);
                break;
            case 2:
                resultTemp = modifyThirdLine(resultTemp, quotient);
                break;
            }
            result.append(resultTemp);
        }
        return result.toString();
    }

    private String addIndents(Step step) {
        int i = step.getCountOfSpaces() + 2; // 2 - adding one space at the beginning (input number length is minimum 1);
        String result = String.format("%" + i + "s%n", step.getValue());
        return result;
    }

    private String modifyFirstLine(String resultTemp) {
        StringBuilder result = new StringBuilder(resultTemp);
        int end = resultTemp.length() - 2;
        result.replace(1, end, (dividend + "|" + divisor));// 2 - means '/n' in the end of resultTemp string from addIndents() method
        return result.toString();
    }

    private String modifySecondLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp);
        int numberOfSpaces = tools.countOfDigits(dividend) + 1 - (resultTemp.length() - 2);// (1 - means '_' at the beginning) 2 - means '/n' in the end of resultTemp string from addIndents() method                                                                                         
        String spaces = tools.drawSymbols(numberOfSpaces, ' ');
        String dashes = tools.drawSymbols(quotient.length(), '-');
        result.insert(resultTemp.length() - 2, spaces + "|" + dashes);
        return result.toString();
    }

    private String modifyThirdLine(String resultTemp, String quotient) {
        StringBuilder result = new StringBuilder(resultTemp);
        String spaces = tools.drawSymbols((tools.countOfDigits(dividend) + 1 - (resultTemp.length() - 2)), ' ');
        result.insert((resultTemp.length() - 2), spaces + "|" + quotient);
        return result.toString();
    }
}
