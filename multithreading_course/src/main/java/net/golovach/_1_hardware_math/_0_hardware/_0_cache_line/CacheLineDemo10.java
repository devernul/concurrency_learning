package net.golovach._1_hardware_math._0_hardware._0_cache_line;

/**
 * Created by kruart on 25.09.2017.
 */
public class CacheLineDemo10 {
    final static int ARRAY_SIZE = 64 * 1024 * 1024;

    public static void main(String[] args) {
        byte[] arr = new byte[ARRAY_SIZE];

        for (int testIndex = 0; testIndex < 10; testIndex ++) {
            testMethod(arr);
            System.out.println("---");
        }
    }

    private static void testMethod(byte[] array) {

        for (int stepSize = 4; stepSize <= 512; stepSize *= 2) {
            long t0 = System.nanoTime();
            int sum = 0;

            for (int n = 0; n < 100; n++) {
                for (int k = 0; k < array.length; k += stepSize) {
                    sum += array[k];
                }
            }
            long t1 = System.nanoTime();
            if (sum > 0) {
                throw new Error();
            }
            int step_count = ARRAY_SIZE / stepSize;
            System.out.println(stepSize + " . dT / step_count: " + (t1 - t0) /step_count);
        }
    }
}
