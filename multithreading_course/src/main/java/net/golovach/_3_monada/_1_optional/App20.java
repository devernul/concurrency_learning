package net.golovach._3_monada._1_optional;

import java.util.Optional;

public class App20 {
    public static void main(String[] args) {
        Integer k = 42;
        Optional<Integer> optK = Optional.of(k);
        Optional<Integer> optN = Optional.empty();

        Integer p = k + 1;
        Optional<Integer> optP = optK.map(x -> x + 1);

    }
}
