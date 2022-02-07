package com.foxminded.division;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Division {
    private int dividend;
    private int divisor;
    private List<Step> divisionSteps = new ArrayList<>();
    private StringBuilder quotient = new StringBuilder();

    public Division(int dividend, int divisor) {

        this.dividend = dividend;
        this.divisor = divisor;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public void setDivisionSteps(Step step) {
        divisionSteps.add(step);
    }

    public void setQuotient(String quotient) {
        this.quotient.append(quotient);
    }

    public int getDividend() {
        return this.dividend;
    }

    public int getDivisor() {
        return this.divisor;
    }

    public List<Step> getDivisionSteps() {
        return this.divisionSteps;
    }

    public String getQuotient() {
        return this.quotient.toString();
    }

    public int hashcode() {
        return Objects.hash(dividend, divisor, divisionSteps, quotient);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Division other = (Division) otherObject;
        return dividend == other.dividend && divisor == other.divisor
                && Objects.equals(divisionSteps, other.divisionSteps) && Objects.equals(quotient, other.quotient);
    }
}
