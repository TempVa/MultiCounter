package com.shvedov.NegativeSum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class NegativeSummer {
    volatile int sum;

    public void getSum (String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.parallel().forEach(this::startSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startSum(String string) {
        int[] temp = Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        sum = Arrays.stream(temp).parallel().filter(o -> o < 0)
                .reduce((s1, s2) -> s1 + s2).orElse(0);
    }

    public void printResult() {
        System.out.println(sum);
    }
}
