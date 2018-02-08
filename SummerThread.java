package com.shvedov;

import java.util.Scanner;

class SummerThread extends Thread {
    private final Scanner stream;
    private final Summer summer;

    SummerThread(Scanner stream, Summer summer) {
        this.stream = stream;
        this.summer = summer;
    }

    @Override
    public void run() {
        while (summer.isAlive() && stream.hasNextInt())
            summer.addNumber(stream.nextInt());
        if (summer.isAlive() && stream.hasNext()) {
            System.out.println("Error. Incorrect number");
            summer.die();
        }
        stream.close();
    }
}
