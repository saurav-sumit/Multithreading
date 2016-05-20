/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.basics;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
class PrintImage implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread is executing");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PrintImage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

public class ThreadGroupExample {

    public static void main(String[] args) {
        PrintImage pi = new PrintImage();
        ThreadGroup tg = new ThreadGroup("Print");
        Thread tA = new Thread(tg, pi, "p1");
        Thread tB = new Thread(tg, pi, "p2");
        Thread tC = new Thread(tg, pi, "p3");

        tA.start();
        tB.start();
        tC.start();
        
        System.out.println("Thread Group Name: " + tg.getName());
        System.out.println("Active count :" + tg.activeCount());
        System.out.println("Thread Group Information");
        tg.list();

    }

}
