package net.golovach._1_hardware_math._0_hardware._0_ILP;

/**
 * Created by kruart on 23.09.2017.
 */
public class ILP_1_1 {

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        double d0 = 0;
        for (int i = 0; i < 100_000_000; i++) {
            d0 = d0 * d0;
        }
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
        System.out.println(d0);
    }
}
