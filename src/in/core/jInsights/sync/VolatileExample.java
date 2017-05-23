/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.sync;

import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {
                Thread.sleep(100);
                count++;
            } catch (InterruptedException ex) {
                Logger.getLogger(TaskA.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        System.out.println("running flag is set to false.");
    }

}
