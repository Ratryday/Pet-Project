package pet.project.service.concurrency;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Task implements Runnable {


    private static final Logger log = Logger.getLogger(Task.class.getName());

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Task: " + LocalDateTime.now());
    }
}