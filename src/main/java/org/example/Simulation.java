package org.example;

public class Simulation {
    public void runSim() throws InterruptedException {
        System.out.println("Running simulation");
        Account myAccount = new Account(1000);

        Runnable runWithdraw = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    myAccount.withdraw(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(runWithdraw, "Thread 1");
        Thread thread2 = new Thread(runWithdraw, "Thread 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Simulation complete. Total withdrawn: " + myAccount.getAmountWithdrawn() +
                ". Current balance: " + myAccount.getBalance());
    }
}
