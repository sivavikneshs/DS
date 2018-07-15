package com.siva;

public class Print {

    private boolean isOdd = true;

    public synchronized void printOdd(final int i) {
        while (!isOdd) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i + "   " + Thread.currentThread() +"  ODD " );
        isOdd = false;
        notifyAll();
    }

    public synchronized void printEven(final int i) {
        while (isOdd) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i + "   " + Thread.currentThread());
        isOdd = true;
        notifyAll();
    }
}
