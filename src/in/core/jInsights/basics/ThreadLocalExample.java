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
class MyRunnable implements Runnable {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        System.out.println("threadLocal :" + threadLocal.get());
    }

}

public class ThreadLocalExample {

    public static void main(String[] args) {
        MyRunnable runable = new MyRunnable();
        Thread tA = new Thread(runable);
        Thread tB = new Thread(runable);
        tA.start();
        tB.start();
    }

}
