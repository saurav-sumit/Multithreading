package in.core.jInsights.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

class Incrementer implements Runnable {

    AtomicInteger atomicnumber = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            IncrementAtomicNumber();
        }

    }

    public void IncrementAtomicNumber() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        atomicnumber.addAndGet(1);
    }

    public AtomicInteger getIncrementedAtomicNumber() {
        return atomicnumber;
    }

}

public class AtomicIntegerExample {

    public static void main(String[] args) {
        Incrementer inc = new Incrementer();
        Thread tA = new Thread(inc);
        tA.start();
        try {
            tA.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(AtomicIntegerExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("final value " + inc.atomicnumber);
    }

}
