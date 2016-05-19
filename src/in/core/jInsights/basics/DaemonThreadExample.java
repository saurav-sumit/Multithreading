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
class NetworkStatus implements Runnable {

    String ip;

    public NetworkStatus(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {

        while (true) {
            System.out.println(Thread.currentThread().getName() + " is checking network status of " + ip);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(NetworkStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

public class DaemonThreadExample {

    public static void main(String[] args) throws InterruptedException {
        NetworkStatus ns = new NetworkStatus("XXX.XX.X.X");
        Thread t = new Thread(ns);
        // To make user thread to daemon thread 
        t.setDaemon(true);
        t.start();
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName() + " thread is [user thread] completed .... and as no user thread is running ,daemon thread  is terminted by the JVM......");
    }
}
