package com.foxminded.calculator;

import com.foxminded.formatter.*;
import com.foxminded.division.*;

public class Calculator {

    private FormatterTools tools = new FormatterTools();

    public void calculate(Division division) {

        if (division.getDivisor() == 0) {
            throw new ArithmeticException("Divisor is zero. Cannot divide by 0.");
        }

        division.setDividend(Math.abs(division.getDividend()));
        division.setDivisor(Math.abs(division.getDivisor()));

        String dividendTemp = "";
        int dividendTempNumber;
        StringBuilder quotientTemp = new StringBuilder();

        char[] digits = String.valueOf(division.getDividend()).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            dividendTemp += digits[i];
            dividendTempNumber = Integer.parseInt(dividendTemp);

            if (dividendTempNumber >= division.getDivisor()) {
                division.setDivisionSteps(new Step("_" + dividendTempNumber, i));

                String product = String.valueOf(dividendTempNumber / division.getDivisor() * division.getDivisor());
                division.setDivisionSteps(new Step(product, i));

                String dash = tools.drawSymbols(product.length(), '-');
                division.setDivisionSteps(new Step(dash, i));

                quotientTemp.append(dividendTempNumber / division.getDivisor());

                if (i == digits.length - 1) {
                    String reminder = String.valueOf(dividendTempNumber % division.getDivisor());
                    division.setDivisionSteps(new Step(reminder, i));
                }
            } else {
                quotientTemp.append("0");
                if (i == digits.length - 1) {
                    division.setDivisionSteps(new Step(String.valueOf(dividendTempNumber), i));
                }
            }
            dividendTemp = String.valueOf(dividendTempNumber % division.getDivisor());

        }
        String result = quotientTemp.toString().replaceFirst("^0+(?!$)", "");
        division.setQuotient(result);
    }
}