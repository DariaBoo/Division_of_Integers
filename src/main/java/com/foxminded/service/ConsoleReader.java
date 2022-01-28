package com.foxminded.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.foxminded.divisor.*;

public class ConsoleReader {

    public Division readCorrectData() {
        int dividend = 0;
        int divisor = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input positive dividend:");
            dividend = scanner.nextInt();
            System.out.print("Input positive divisor:");
            divisor = scanner.nextInt();
        } catch (ArithmeticException | InputMismatchException exception) {
            exception.printStackTrace();
        }
        return new Division(dividend, divisor);
    }
}
