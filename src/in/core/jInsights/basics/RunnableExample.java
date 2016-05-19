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
class NumberTable implements Runnable {

    int number;

    public NumberTable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s : %d * %d  = %d \n", Thread.currentThread().getName(), number, i, number * i);
        }
    }

}

public class RunnableExample {

    public static void main(String[] args) {
        Runnable r = new NumberTable(5);
        Thread tA = new Thread(r);
        Thread tB = new Thread(r);
        tA.start();
        tB.start();

    }
}
