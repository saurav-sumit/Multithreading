/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.core.jInsights.uc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sumit kumar saurav<sumitk@cdac.in>
 * calculate res = sin(x)+cos(x)+tan(x) 
 */
class TrigonomatricCalculator extends Thread {

    private double degree;
    private double res;
    private String fName;

    public TrigonomatricCalculator(double degree, String fName) {
        this.degree = degree;
        this.fName = fName;
    }

    public double getRes() {
        return res;
    }

    @Override
    public void run() {
        double Deg2Rad = 0;
        switch (fName) {
            case "sin":
                Deg2Rad = Math.toRadians(degree);
                res = Math.sin(Deg2Rad);
                break;
            case "cos":
                Deg2Rad = Math.toRadians(degree);
                res = Math.cos(Deg2Rad);
                break;
            case "tan":
                Deg2Rad = Math.toRadians(degree);
                res = Math.tan(Deg2Rad);
                break;
            default:
                res = 0.0;
        }
    }

}

public class TrigonomatricCalculatorExample {

    public static void main(String[] args) {
        double result = 0;
        TrigonomatricCalculator sin = new TrigonomatricCalculator(45, "sin");
        TrigonomatricCalculator cos = new TrigonomatricCalculator(45, "cos");
        TrigonomatricCalculator tan = new TrigonomatricCalculator(45, "tan");

        sin.start();
        cos.start();
        tan.start();

        try {
            sin.join();
            cos.join();
            tan.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TrigonomatricCalculatorExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        result = sin.getRes() + cos.getRes() + tan.getRes();
        System.out.println("sin(x)+cos(x)+tan(x) = " + result);
    }
}
