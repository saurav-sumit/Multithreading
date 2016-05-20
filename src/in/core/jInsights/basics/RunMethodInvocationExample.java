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
class ThreadX extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

    }
}

public class RunMethodInvocationExample {
    public static void main(String[] args) {
        ThreadX tA= new ThreadX();
        ThreadX tB= new ThreadX();
        tA.start();
        // calling run method will not spwan new thread. it will be executed by main thread. 
        tB.run();
        
        // start method on should not be called twice 
        //otherwise it will throw runtime exception [java.lang.IllegalThreadStateException]  
       // tA.start();
    }
}
