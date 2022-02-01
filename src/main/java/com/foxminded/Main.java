package com.foxminded;

import com.foxminded.consoleReader.*;
import com.foxminded.facade.*;

public class Main {

    public static void main(String[] args) {
        CalculatorFacade facade = new CalculatorFacade();
        System.out.println(facade.initCalculation(new ConsoleReader().readData()));
    }
}
