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
public class MainThreadExample {

    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread completed ...");
    }
}
