package ua.kruart.chapter06_parallel_and_reactive_streams.recipe06_transforming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kruart on 22.10.2017.
 */
public class FileGenerator {


    public static List<String> generateFile(int size) {
        List<String> file = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            file.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi lobortis cursus venenatis. " +
                    "Mauris tempus elit ut malesuada luctus. Interdum et malesuada fames ac ante ipsum primis in faucibus. " +
                    "Phasellus laoreet sapien eu pulvinar rhoncus. Integer vel ultricies leo. " +
                    "Donec vel sagittis nibh. Maecenas eu quam non est hendrerit pu");
        }
        return file;
    }
}
