package ua.kruart.chapter06_parallel_and_reactive_streams.recipe05_filtering;

import ua.kruart.chapter06_parallel_and_reactive_streams.recipe04_forEach_forEachOrdered_peek.Person;
import ua.kruart.chapter06_parallel_and_reactive_streams.recipe04_forEach_forEachOrdered_peek.PersonGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kruart on 22.10.2017.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> persons = PersonGenerator.generatePersonList(10);

        // Distinct with objects
        System.out.printf("********************************************************\n");
        System.out.printf("Original List\n");
        persons.parallelStream().forEach(p-> {
            System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
        });
        System.out.printf("********************************************************\n");
        System.out.printf("\n");

        System.out.printf("********************************************************\n");
        System.out.printf("List Without duplicates\n");
        persons.parallelStream().distinct().forEach(p-> {
            System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
        });
        System.out.printf("********************************************************\n");
        System.out.printf("\n");

        // Distinct with numbers
        System.out.printf("********************************************************\n");
        System.out.printf("Array of numbers without duplicates\n");
        Integer[] numbers={1,3,2,1,2,2,1,3,3,1,1,3,2,1};
        Arrays.asList(numbers).parallelStream().mapToInt(n -> n).distinct().forEach(n -> {
            System.out.printf("Number: %d\n", n);
        });
        System.out.printf("********************************************************\n");
        System.out.printf("\n");

        // Filter with objects
        System.out.printf("********************************************************\n");
        System.out.printf("Filter with persons\n");
        persons.parallelStream().filter(p -> p.getSalary() < 30000)
                .forEach( p -> System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName()));
        System.out.printf("********************************************************\n");
        System.out.printf("\n");

        // Filter with numbers
        System.out.printf("********************************************************\n");
        System.out.printf("Filter with numbers\n");
        Arrays.asList(numbers).parallelStream().mapToInt(n -> n).filter(n -> n < 2).
                forEach(n-> System.out.printf("%d\n", n));
        System.out.printf("********************************************************\n");
        System.out.printf("\n");

        //Limit and skip with numbers
        System.out.printf("********************************************************\n");
        System.out.printf("Limit with numbers\n");
        persons.parallelStream().mapToDouble(Person::getSalary).sorted().limit(5).forEach(s-> {
            System.out.printf("Limit: %f\n",s);
        });
        System.out.printf("********************************************************\n");
        System.out.printf("\n");

        //Skip to ignore a number of elements of the stream
        System.out.printf("********************************************************\n");
        System.out.printf("Skip with numbers\n");
        persons.parallelStream().mapToDouble(p -> p.getSalary()).sorted().skip(5).forEach(s-> {
            System.out.printf("Skip: %f\n", s);
        });
        System.out.printf("********************************************************\n");
        System.out.printf("\n");


        //takeWhile and dropWhile
        System.out.printf("********************************************************\n");
        System.out.printf("Skip with numbers\n");
        Integer[] numbers1 = {1, 3, 2, 1};
        Arrays.asList(numbers1).parallelStream().dropWhile(e -> e < 2).forEach(System.out::println);
        Arrays.asList(numbers1).parallelStream().takeWhile(e -> e < 2).forEach(System.out::println);

        System.out.printf("********************************************************\n");
        System.out.printf("\n");

    }

}
