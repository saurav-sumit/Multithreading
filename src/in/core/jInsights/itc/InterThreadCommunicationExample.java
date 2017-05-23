package in.core.jInsights.itc;

class Summation implements Runnable {

    private int total;
    private final int num;

    public Summation(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= num; i++) {
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
        Summation sum = new Summation(50);
        Thread tA = new Thread(sum);
        tA.start();
        synchronized (sum) {
            try {
                System.out.println(Thread.currentThread().getName() + " thread is waiting for notification ...");
                sum.wait();
                System.out.println(Thread.currentThread().getName() + " is notifed  ....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+ "Total is " + sum.getTotal());
    }

}
