package in.core.jInsights.itc;

class Adder implements Runnable {

    private int total;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 50; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                total += i;
            }
            System.out.println(Thread.currentThread().getName() + " is completed computation and going to notify .....");
            notify();
        }
    }

    public int getTotal() {
        return total;
    }
}

public class InterThreadCommunicationExample {

    public static void main(String[] args) {
        Adder adder = new Adder();
        Thread tA = new Thread(adder);
        tA.start();
        synchronized (adder) {
            try {
                System.out.println(Thread.currentThread().getName() + " thread is waiting for Adder's notification ...");
                adder.wait();
                System.out.println(Thread.currentThread().getName()+" is notifed  ....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total is " + adder.getTotal());
    }

}
