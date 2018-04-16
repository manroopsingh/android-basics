package com.example.questions.multithreading.increment_static_counter_with_threads;

public class MyRunnable implements Runnable {


    Object lock;

    public MyRunnable(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        System.out.println("Running state for : "
                + Thread.currentThread().getName());

        synchronized (lock) {

            System.out.println("In synchronized block");

            for (int i = 0; i < 10; i++) {

                //increment the counter
                Thread_ordering.MyCounter.counter++;

                //print out the value for counter by thread
                System.out.println("Counter is at :"
                        + Thread_ordering.MyCounter.counter
                        + " by: "
                        + Thread.currentThread().getName());

                try {
                    Thread.sleep(500);
                    //notifies the waiting thread on the object monitor
                    lock.notify();
                    //wait for the other thread to finish
                    lock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}