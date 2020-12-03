package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.stereotype.Service;

@Service
public class RunnableLambda {

    // Anonymous class definition of the Runnable interface.
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Hello world from the thread runnable [" + Thread.currentThread().getName() + "] ");
            }

        }

    };

    // Lambda Expression definition of the Runnable interface.
    Runnable runnableLambda = () -> { for (int i = 0; i < 3; i++) {
            System.out.println("Hello world from the thread runnableLambda [" + Thread.currentThread().getName() + "] "); }
    };

    //Core calling logic.
    {
        System.out.println("From the thread :[" + Thread.currentThread().getName() + "]");
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnableLambda);
        thread2.start();
        try {
             thread1.join();
             thread2.join();
             System.out.println("Back to the thread :[" + Thread.currentThread().getName() + "]");
        } catch (InterruptedException e) {
            System.out.println("from the thread ["+ Thread.currentThread().getName() + "]: " + e);
        }
    }



}
