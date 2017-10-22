package ua.kruart.chapter06_parallel_and_reactive_streams.recipe02_reducing.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kruart on 22.10.2017.
 */
public class PointGenerator {

    public static List<Point> generatePointList (int size) {
        List<Point> ret = new ArrayList<>();

        Random randomGenerator = new Random();
        for (int i = 0; i < size; i++) {
            Point point = new Point();
            point.setX(randomGenerator.nextDouble());
            point.setY(randomGenerator.nextDouble());
            ret.add(point);
        }

        return ret;
    }
}
