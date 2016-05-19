/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.sync;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class TaskA implements Runnable {

    volatile boolean running = true;
    // boolean running = true;

    @Override
    public void run() {
        int count = 0;
        while (running) {
            count++;
        }
        System.out.println("Thread terminated." + count);
    }
}

public class VolatileExample {

    public static void main(String[] args) throws InterruptedException {
        TaskA task = new TaskA();
        Thread tA = new Thread(task);
        tA.start();
        Thread.sleep(1000);
        task.running = false;
        System.out.println("keepRunning set to false.");
    }

}
