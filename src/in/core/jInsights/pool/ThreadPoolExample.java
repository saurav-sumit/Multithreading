/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class Worker implements Runnable {
    String message;

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " is greeting !!! " + message);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is finished the assinged task");

    }

    public Worker(String message) {
        this.message = message;
    }

}

public class ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            Worker worker = new Worker("Hello employee ["+i+"]");
            executor.execute(worker);// calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }

}
