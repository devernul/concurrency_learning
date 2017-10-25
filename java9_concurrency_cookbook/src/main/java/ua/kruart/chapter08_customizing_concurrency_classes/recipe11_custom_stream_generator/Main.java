package ua.kruart.chapter08_customizing_concurrency_classes.recipe11_custom_stream_generator;

import ua.kruart.chapter08_customizing_concurrency_classes.recipe11_custom_stream_generator.spliterator.Item;
import ua.kruart.chapter08_customizing_concurrency_classes.recipe11_custom_stream_generator.spliterator.MySpliterator;

import java.util.stream.StreamSupport;

/**
 * Created by kruart on 25.10.2017.
 */
public class Main {

    public static void main(String[] args) {
        Item[][] items = new Item[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                items[i][j] = new Item();
                items[i][j].setRow(i);
                items[i][j].setColumn(j);
                items[i][j].setName("Item " + i + " " + j);
            }
        }

        MySpliterator mySpliterator = new MySpliterator(items, 0, items.length);
        System.out.println(mySpliterator.characteristics());

        StreamSupport.stream(mySpliterator, true).forEach(item -> {
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), item.getName());
        });

    }

}
