package com.example.questions.multithreading;

public class Thread_ordering {

    public static void main(String[] args) {


        Object lock = new Object();

        MyRunnable myRunnable = new MyRunnable(lock);
        Thread t1 = new Thread(myRunnable, "thread1");
        Thread t2 = new Thread(myRunnable, "thread2");

        t1.start();
        t2.start();
        

    }

    public static class MyCounter {
        public static int counter = 0;
    }


}
