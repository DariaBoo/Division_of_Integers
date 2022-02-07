package com.foxminded.division;

import java.util.Objects;

public class Step {
    private String value;
    private int countOfSymbols;

    public Step(String value, int countOfSymbols) {
        this.value = value;
        this.countOfSymbols = countOfSymbols;
    }

    public String getValue() {

        return this.value;
    }

    public int getCountOfSymbols() {

        return this.countOfSymbols;
    }

    public int hashcode() {
        return Objects.hash(value, countOfSymbols);
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
        Step other = (Step) otherObject;
        return Objects.equals(value, other.value) && countOfSymbols == other.countOfSymbols;
    }
}
