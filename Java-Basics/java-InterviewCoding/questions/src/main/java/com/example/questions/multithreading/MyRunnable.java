package com.example.questions.multithreading;

public class MyRunnable implements Runnable {


    Object lock;

    public MyRunnable(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {

            for (int i = 0; i < 10; i++) {

                Thread_ordering.MyCounter.counter++;
                System.out.println("Counter is at :"
                        + Thread_ordering.MyCounter.counter
                        + " by: "
                        + Thread.currentThread().getName());

                try {

                    Thread.sleep(500);
                    lock.notify();
                    lock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}