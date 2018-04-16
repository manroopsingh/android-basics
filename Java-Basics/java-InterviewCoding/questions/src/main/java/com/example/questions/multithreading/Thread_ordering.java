package com.example.questions.multithreading;

public class Thread_ordering {

    public static void main(String[] args) throws InterruptedException {


        //create a object to be used as a lock
        Object lock = new Object();

        //pass the lock to the runnable for thread synchronization
        MyRunnable myRunnable = new MyRunnable(lock);

        //create threads with same runnable and different thread names
        Thread t1 = new Thread(myRunnable, "thread1");
        Thread t2 = new Thread(myRunnable, "thread2");

        //start the threads
        t1.start();
        t2.start();




    }

    public static class MyCounter {
        public static int counter = 0;
    }


}
