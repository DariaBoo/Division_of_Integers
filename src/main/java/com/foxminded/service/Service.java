package com.foxminded.service;

public class Service {

    public static void main(String[] args) {
        ConsoleReader console = new ConsoleReader();
        System.out.println(console.readCorrectData().calculate());
    }   
}
