package net.golovach._1_hardware_math._0_hardware._0_ILP;

/**
 * Created by kruart on 23.09.2017.
 */
public class ILP_10_10 {

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        double d0 = 0;
        double d1 = 0;
        double d2 = 0;
        double d3 = 0;
        double d4 = 0;
        double d5 = 0;
        double d6 = 0;
        double d7 = 0;
        double d8 = 0;
        double d9 = 0;
        for (int i = 0; i < 100_000_000; i++) {
            d0 = d0 * d0;
            d1 = d1 * d1;
            d2 = d2 * d2;
            d3 = d3 * d3;
            d4 = d4 * d4;
            d5 = d5 * d5;
            d6 = d6 * d6;
            d7 = d7 * d7;
            d8 = d8 * d8;
            d9 = d9 * d9;
        }
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
    }
}
