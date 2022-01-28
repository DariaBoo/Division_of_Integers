package com.foxminded.divisor;

import java.util.Objects;

public class Step {
    private String value;
    private int countOfSpaces;

    public Step(String value, int countOfSpaces) {
        this.value = value;
        this.countOfSpaces = countOfSpaces;
    }

    public String getValue() {

        return this.value;
    }

    public int getCountOfSpaces() {

        return this.countOfSpaces;
    }

    public int hashcode() {
        return Objects.hash(value, countOfSpaces);
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
        return Objects.equals(value, other.value) && countOfSpaces == other.countOfSpaces;
    }
}
