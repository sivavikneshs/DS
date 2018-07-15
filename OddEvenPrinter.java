package com.siva;

public class OddEvenPrinter implements Runnable {

    private boolean isOdd;
    private Print print;

    OddEvenPrinter(boolean isOdd, Print print) {
        this.isOdd = isOdd;
        this.print = print;
    }

    @Override public void run() {

        for (int i = 1; i <= 10; i += 2) {
            if (!isOdd) {
                print.printEven(i + 1);
            }
            else {
                print.printOdd(i);
            }

        }

    }

}
