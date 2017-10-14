package ua.kruart.chapter02_basic_synchronization.recipe01_solution_sync;

import ua.kruart.chapter02_basic_synchronization.recipe01_solution_sync.parking.ParkingCash;
import ua.kruart.chapter02_basic_synchronization.recipe01_solution_sync.parking.ParkingStats;
import ua.kruart.chapter02_basic_synchronization.recipe01_solution_sync.parking.Sensor;

/**
 * Created by kruart on 14.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);

        System.out.printf("Parking Simulator\n");

        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread threads[] = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of cars: %d\n", stats.getNumberCars());
        System.out.printf("Number of motorcycles: %d\n", stats.getNumberMotorcycles());
        cash.close();
    }

}
