package com.shvedov;

class Summer {
    private int sum;
    private boolean isAlive = true;

    public synchronized void addNumber(int num) {
        if (num > 0 && num % 2 == 0) {
            this.sum += num;
            System.out.println("Current sum: " + sum);
        }
    }

    public void die() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
