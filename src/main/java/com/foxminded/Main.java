package com.foxminded;

import com.foxminded.consoleReader.*;
import com.foxminded.validator.*;

public class Main {

    public static void main(String[] args) {
        DataValidator validator = new DataValidator();
        System.out.println(validator.initCalculation(new ConsoleReader().readData()));
    }
}
