/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.basics;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class MyTask implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                System.out.println(" i= " + i + " by " + Thread.currentThread().getName());
                Thread.yield();

            }

        }

    }

}

public class ThreadPriorityExample {

    public static void main(String[] args) {

        MyTask task = new MyTask();

        Thread tA = new Thread(task);
        Thread tB = new Thread(task);
        Thread tC = new Thread(task);
        /*
         * Thread tD = new Thread(task); Thread tE = new Thread(task); Thread tF
         * = new Thread(task); Thread tG = new Thread(task);
         */
        tA.setName("Thread-A");
        tB.setName("Thread-B");
        tC.setName("Thread-C");
        /*
         * tD.setName("Thread-D"); tE.setName("Thread-E");
         * tF.setName("Thread-F"); tG.setName("Thread-G");
         */
        tA.setPriority(Thread.MAX_PRIORITY);
        tB.setPriority(Thread.NORM_PRIORITY);
        tC.setPriority(9);
        // Throws java.lang.IllegalArgumentException as thread priority should be 1-10
        //tC.setPriority(99);
        /*
         * tD.setPriority(Thread.MAX_PRIORITY);
         * tE.setPriority(Thread.NORM_PRIORITY);
         * tF.setPriority(Thread.MAX_PRIORITY);
         * tG.setPriority(Thread.MIN_PRIORITY);
         */
        tA.start();
        tB.start();
        tC.start();
        /*
         * tD.start(); tE.start(); tF.start(); tG.start();
         */

    }
}
