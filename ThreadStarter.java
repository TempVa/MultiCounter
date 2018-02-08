package com.shvedov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class ThreadStarter {
    private List<Thread> threads;
    private Summer summer;

    public void getSum(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(this::createThread);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error. File can not be read");
        }
    }


    private void createThread(String s) {
        this.setSummer(new Summer());
        this.setThreads(new LinkedList<>());
        Thread thread = new SummerThread(getScanner(s), getSummer());
        thread.start();
        getThreads().add(thread);
    }

    private Summer getSummer() {
        return this.summer;
    }

    private Scanner getScanner(String s) {
        return new Scanner(s);
    }

    private List<Thread> getThreads() {
        return threads;
    }

    private void setSummer(Summer summer) {
        this.summer = summer;
    }

    private void setThreads(List<Thread> threads) {
        this.threads = threads;
    }
}
