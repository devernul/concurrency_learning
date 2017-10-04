package net.golovach._3_monada._1_optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Редукция не на моноиде, а исключительно на ассоциативной операции
 * необходимо приводит к монаде Optional/Maybe
 */
public class App00 {
    public static void main(String[] args) {
        //Редукция на моноиде (ассоц операторе + нейтральный элем)
        Integer sum0 = Stream.of(1, 2, 3).reduce(0, (x, y) -> x + y);
        System.out.println(sum0);

        //МОНАДА: Optional / Just
        //Редукция на ассоц операторе
        Optional<Integer> sum1 = Stream.of(1, 2, 3).reduce((x, y) -> x + y);
        System.out.println(sum1);

        //МОНАДА: Optional/Nothing
        //Редукция на ассоц операторе
        Optional<Integer> sum2 = Stream.of(1, 2, 3).filter(x -> x > 10).reduce((x, y) -> x + y);
        System.out.println(sum2);


    }
}
