package org.threads;

public class MyThread2 implements Runnable {

    public void run() {
        for (int i = 0; i < 200; i++){
            System.out.println("This code is running in a MyThread1");
        }
    }
}
