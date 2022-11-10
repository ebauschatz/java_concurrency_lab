package org.example;

public class Account {
    private int balance;
    private int amountWithdrawn;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAmountWithdrawn() {
        return amountWithdrawn;
    }

    public void setAmountWithdrawn(int amountWithdrawn) {
        this.amountWithdrawn = amountWithdrawn;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        if (amount <= this.balance) {
            Thread.sleep(50);
            this.balance -= amount;
            this.amountWithdrawn += amount;
            System.out.println(amount + " withdrawn by " + threadName + ". New balance is " + this.balance + ". Total withdrawn: " + this.amountWithdrawn);
        }
        else {
            System.out.println("Insufficient funds for " + threadName + ". Total withdrawn " + this.amountWithdrawn);
        }
    }
}
