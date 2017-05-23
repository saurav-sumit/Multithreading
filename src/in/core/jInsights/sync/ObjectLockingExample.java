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
class CA {

    public synchronized void m1() {
        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName() + " is executing  m1  " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void m2() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is executing  m2  " + i);
        }
    }
    public void m3() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is executing  m3  " + i);
        }
    }

    //public static void ms1() {
    public static synchronized void ms1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is executing static method ms1  " + i);
        }
    }
}

public class ObjectLockingExample {

    public static void main(String[] args) {
        final CA ca = new CA();
        new Thread() {

            @Override
            public void run() {
                ca.m1();
            }

        }.start();

        new Thread() {

            @Override
            public void run() {
                // Method m2 will be blocked by m1 , both Thread will run one after another as object will be Locked  
                // ca.m2();
                // Method m3 will be executed concurrently as this method is not synchronized
                // ca.m3();
                // Method m4 will be executed concurrently as synchronized static method acquire class lock it will not be blocked by non static synchronized method and object level lock
                CA.ms1();
            }

        }.start();
    }

}
