package pet.project.service.concurrency;

import java.time.LocalDateTime;

public class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task: " + LocalDateTime.now());
    }
}