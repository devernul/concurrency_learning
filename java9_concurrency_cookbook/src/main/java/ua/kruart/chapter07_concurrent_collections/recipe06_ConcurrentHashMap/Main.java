package ua.kruart.chapter07_concurrent_collections.recipe06_ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by kruart on 23.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        ConcurrentHashMap<String, ConcurrentLinkedDeque<Operation>> userHash = new ConcurrentHashMap<>();
        HashFiller hashFiller = new HashFiller(userHash);

        //Execute 10 threads with the HashFiller class
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(hashFiller);
            threads[i].start();
        }

        //wait for their finalization using the join() method
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //extract the information of ConcurrentHashMap
        System.out.printf("Size: %d\n", userHash.size());

        userHash.forEach(10, (user, list) -> {
            System.out.printf("%s: %s: %d\n", Thread.currentThread().getName(), user, list.size());
        });

        //use the forEachEntry() method. This is similar to the previous one, but the lambda expression
        // receives an Entry object as a parameter instead of receiving two parameters
        userHash.forEachEntry(10, entry -> {
            System.out.printf("%s: %s: %d\n", Thread.currentThread().getName(), entry.getKey(), entry.getValue().size());
        });

        //use the search() method to find the first element that satisfies the search function specified
        Operation op = userHash.search(10, (user, list) -> {
            for (Operation operation : list) {
                if (operation.getOperation().endsWith("1")) {
                    return operation;
                }
            }
            return null;
        });

        System.out.printf("The operation we have found is: %s, %s, %s,\n", op.getUser(), op.getOperation(),
                op.getTime());

        //Use the search() method again, but this time, use it to find a user with more than 10 operations
        ConcurrentLinkedDeque<Operation> operations = userHash.search(10, (user, list) -> {
            if (list.size() > 10) {
                return list;
            }
            return null;
        });

        System.out.printf("The user we have found is: %s: %d operations\n", operations.getFirst().getUser(),
                operations.size());

        //Finally, use the reduce() method to calculate the total number of operations stored in the hash
        int totalSize = userHash.reduce(10, (user, list) -> {
            return list.size();
        }, (n1, n2) -> {
            return n1 + n2;
        });

        System.out.printf("The total size is: %d\n", totalSize);

    }

}
