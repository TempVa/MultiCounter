package com.shvedov;

import com.shvedov.NegativeSum.NegativeSummer;
import com.shvedov.PositiveEvenSum.ThreadStarter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Main {
    private static String pathToNeg = "C:\\Users\\innopolis\\Desktop\\MultiCounter\\src\\com\\shvedov\\NegativeSum\\";
    private static String pathToPos = "C:\\Users\\innopolis\\Desktop\\MultiCounter\\src\\com\\shvedov\\PositiveEvenSum\\";

    public static void main(String[] args) {
        /*boolean summerPositive = true;
        ModuleEngine moduleEngine = new ModuleEngine();*/

        ThreadStarter threadStarter = new ThreadStarter();
        String filePath = "C:\\Users\\innopolis\\Desktop\\data\\converted.txt";

        System.out.println("Numbers");

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Negative Sum");
        NegativeSummer negativeSummer = new NegativeSummer();
        negativeSummer.getSum(filePath);
        negativeSummer.printResult();

        System.out.println();
        System.out.println("Positive Even Sum in livetime");
        threadStarter.getSum(filePath);

        /*Scanner in = new Scanner(System.in);
        options();
        switch (in.nextLine()) {
            case "pes":
                moduleEngine.execute(pathToPos);
                summerPositive = true;
                break;
            case "ns":
                moduleEngine.execute(pathToNeg);
                summerPositive = false;
                break;
            case "swap":
                if (summerPositive) {
                    moduleEngine.execute(pathToPos);
                    summerPositive = true;
                } else {
                    moduleEngine.execute(pathToNeg);
                    summerPositive = false;
                }
                break;
            default:
                System.out.println("Please try again and choose available options.");
                options();
        }*/
    }

    /*private static void options() {
        System.out.println("If you want to use positive even summer, print pes; If you want negative summer, print ns; If you want to swap summers, print swap.");
    }*/
}
