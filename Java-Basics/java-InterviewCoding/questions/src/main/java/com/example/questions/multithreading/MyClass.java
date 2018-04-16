package com.example.questions.multithreading;

public class MyClass {

    private static Object lock = new Object();

    public static void main(String args[]) throws InterruptedException {

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<20; i=i+2){
                    synchronized (lock) {
                        System.out.println("Thread 1: "+i);
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Error in Thread 1: "+e.getMessage());
                        }
                    }
                }
            }
        };


        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=2; i<=20; i=i+2){
                    synchronized (lock) {
                        System.out.println("Thread 2: "+i);
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Error in Thread 2: "+e.getMessage());
                        }
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        System.out.println("Thread Start: ");
        thread1.start();
        thread2.start();

        thread1.join();
    }

}