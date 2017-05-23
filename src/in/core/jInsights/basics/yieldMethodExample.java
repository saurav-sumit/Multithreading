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
class TaskZ implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + " is executing ... i=" + i);
                Thread.yield();
            }
        }
    }

}

public class yieldMethodExample {

    public static void main(String[] args) {
        TaskZ taskZ = new TaskZ();
        Thread tA = new Thread(taskZ);
        Thread tB = new Thread(taskZ);
        Thread tC = new Thread(taskZ);
        tA.setPriority(9);
        tB.setPriority(9);
        tC.setPriority(7);
        tA.start();
        tB.start();
        tC.start();

    }

}
