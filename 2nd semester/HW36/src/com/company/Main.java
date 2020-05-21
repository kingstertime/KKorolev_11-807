package com.company;

import java.util.Random;


public class Main {
    public static int mainSum = 0;

    public static void main(String[] args) throws InterruptedException {
        int [] arr = new int[1000000];
        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
            sumArr += arr[i];
        }
        System.out.println(sumArr + " - без потоков");

        Thread t1 = new CounterThread(0,2000, arr);
        Thread t2 = new CounterThread(2000,400000, arr);
        Thread t3 = new CounterThread(4000,600000, arr);
        Thread t4 = new CounterThread(600000,8000, arr);
        Thread t5 = new CounterThread(800,10000, arr);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println(mainSum + " - c потоками");

    }
}
