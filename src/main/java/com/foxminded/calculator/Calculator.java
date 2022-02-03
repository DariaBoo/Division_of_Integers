package com.foxminded.calculator;

import com.foxminded.formatter.*;
import com.foxminded.division.*;

public class Calculator {

    private FormatterTools tools = new FormatterTools();
    private final String quotientZero = "0";

    public void calculate(Division division) {

        if (division.getDivisor() == 0) {
            throw new ArithmeticException("Divisor is zero. Cannot divide by 0.");
        }

        division.setDividend(Math.abs(division.getDividend()));
        division.setDivisor(Math.abs(division.getDivisor()));

        StringBuilder dividendTemp = new StringBuilder();
        int dividendTempNumber;
        StringBuilder quotient = new StringBuilder();
        int lineLength;

        char[] digits = String.valueOf(division.getDividend()).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            dividendTemp.append(digits[i]);
            dividendTempNumber = Integer.parseInt(dividendTemp.toString());
            lineLength = i + 1;

            if (dividendTempNumber >= division.getDivisor()) {
                division.setDivisionSteps(new Step("_" + dividendTempNumber, lineLength));

                String product = String.valueOf(dividendTempNumber / division.getDivisor() * division.getDivisor());
                division.setDivisionSteps(new Step(product, lineLength));

                String dash = tools.drawSymbols(product.length(), '-');
                division.setDivisionSteps(new Step(dash, lineLength));

                quotient.append(dividendTempNumber / division.getDivisor());

                if (i == digits.length - 1) {
                    String reminder = String.valueOf(dividendTempNumber % division.getDivisor());
                    division.setDivisionSteps(new Step(reminder, lineLength));
                }
            } else {
                quotient.append(quotientZero);
                if (i == digits.length - 1) {
                    division.setDivisionSteps(new Step(String.valueOf(dividendTempNumber), lineLength));
                }
            }
            dividendTemp.setLength(0);
            dividendTemp.append(dividendTempNumber % division.getDivisor());

        }
        String result = quotient.toString().replaceFirst("^0+(?!$)", "");
        division.setQuotient(result);
    }
}