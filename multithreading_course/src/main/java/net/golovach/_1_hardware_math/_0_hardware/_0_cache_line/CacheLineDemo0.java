package net.golovach._1_hardware_math._0_hardware._0_cache_line;

/**
 * Created by kruart on 25.09.2017.
 */
public class CacheLineDemo0 {
    final static int ARRAY_SIZE = 64 * 1024 * 1024;

    public static void main(String[] args) {
        byte[] arr = new byte[ARRAY_SIZE];

        for (int stepSize = 4; stepSize <= 160 ; stepSize += 4) {
            long t0 = System.nanoTime();
            int sum = 0;
            for (int n = 0; n < 100; n++) {
                for (int k = 0; k < arr.length; k += stepSize) {
                    sum += arr[k];
                }
            }
            if (sum > 0 ) {
                throw new Error();
            }
            long t1 = System.nanoTime();
            int step_count = ARRAY_SIZE / stepSize;
            System.out.println(stepSize + " . dT / step_count: " + (t1 - t0) /step_count);
        }
    }
}
