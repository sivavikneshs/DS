package com.siva;

public class OddEven {

    public static void main(String[] args) {
        Print print = new Print();

        Runnable oddPrinter = new OddEvenPrinter(true, print);
        Runnable evenPrinter = new OddEvenPrinter(false, print);

        Thread odd = new Thread(oddPrinter, "odd");
        Thread even = new Thread(evenPrinter, "even");

        odd.start();
        even.start();
    }
}
