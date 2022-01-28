package com.foxminded.divisor;

import java.util.List;

import com.foxminded.formatter.*;

import java.util.ArrayList;

public class Division {
    private int dividend;
    private int divisor;
    private List<Step> divisionSteps = new ArrayList<>();
    private StringBuilder quotient = new StringBuilder();
    private FormatterTools tools = new FormatterTools();

    public Division(int dividend, int divisor) {

        this.dividend = dividend;
        this.divisor = divisor;
    }

    public String calculate() throws ArithmeticException {

        if (divisor == 0) {
            throw new ArithmeticException("Divisor is zero. Cannot divide by 0.");
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor) {
            String message = dividend + " divided by " + divisor + " is equals 0.";
            return message;
        }

        String dividendTemp = "";
        int dividendTempNumber;

        char[] digits = String.valueOf(dividend).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            dividendTemp += digits[i];
            dividendTempNumber = Integer.parseInt(dividendTemp);

            if (dividendTempNumber >= divisor) {
                divisionSteps.add(new Step("_" + dividendTempNumber, i));

                String product = String.valueOf(dividendTempNumber / divisor * divisor);
                divisionSteps.add(new Step(product, i));

                String dash = tools.drawSymbols(product.length(), '-');
                divisionSteps.add(new Step(dash, i));

                quotient.append(dividendTempNumber / divisor);
                if (i == digits.length - 1) {
                    String reminder = String.valueOf(dividendTempNumber % divisor);
                    divisionSteps.add(new Step(reminder, i));
                }
            } else {
                quotient.append(0);
                if (i == digits.length - 1) {
                    divisionSteps.add(new Step(String.valueOf(dividendTempNumber), i));
                }
            }
            dividendTemp = String.valueOf(dividendTempNumber % divisor);
        }
        String quotientResult = quotient.toString().replaceFirst("^0+(?!$)", "");
        String result = new Formatter(dividend, divisor).formattingResult(divisionSteps, quotientResult);
        return result;
    }
}
