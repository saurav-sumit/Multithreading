/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.deadlock;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 *
 */
public class DeadLockExample {

    private String str1 = "Hello";
    private String str2 = "world";

    Thread tA = new Thread() {

        @Override
        public void run() {
            while (true) {
                synchronized (str1) {
                    synchronized (str2) {
                        System.out.println(Thread.currentThread().getName()+" "+str1 + " " + str2);
                    }
                }
            }
        }

    };

    Thread tB = new Thread() {

        @Override
        public void run() {
            while (true) {
                synchronized (str2) {
                    synchronized (str1) {
                        System.out.println(Thread.currentThread().getName()+" "+str2 + " " + str1);
                    }
                }
            }

        }

    };

    public static void main(String[] args) {
        DeadLockExample dl = new DeadLockExample();
        dl.tA.start();
        dl.tB.start();

    }
}
