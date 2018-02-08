package com.shvedov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        ThreadStarter threadStarter = new ThreadStarter();
        String filePath = "C:\\Users\\innopolis\\Desktop\\data\\converted.txt";

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        threadStarter.getSum(filePath);
    }
}
