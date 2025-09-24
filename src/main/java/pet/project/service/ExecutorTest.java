package pet.project.service;

import pet.project.service.concurrency.Invoker;
import pet.project.service.concurrency.Task;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorTest {

  public static void main(String[] args) {
    execute();
    executeService();
    scheduledExecutorService();
  }

  private static void execute() {
    Executor executor1 = new Invoker();
    executor1.execute(() -> System.out.println("Invoker: " + LocalDateTime.now()));
    System.out.println("Executor: " + LocalDateTime.now());
  }

  private static void executeService() {
    ExecutorService executor2 = Executors.newFixedThreadPool(10);
    executor2.submit(new Task());
    System.out.println("ExecutorService: " + LocalDateTime.now());
  }

  private static void scheduledExecutorService() {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    AtomicInteger futureNum = new AtomicInteger();
    executorService.scheduleAtFixedRate(
        () -> System.out.println("scheduleAtFixedRate + " + futureNum.getAndIncrement()),
        1,
        3,
        TimeUnit.SECONDS);

    AtomicInteger scheduledFutureNum = new AtomicInteger();
    executorService.scheduleWithFixedDelay(
        () ->
            System.out.println("scheduleWithFixedDelay + " + scheduledFutureNum.getAndIncrement()),
        2,
        5,
        TimeUnit.SECONDS);

    executorService.schedule(
        () -> System.out.println("schedule + " + scheduledFutureNum.getAndIncrement()),
        5,
        TimeUnit.SECONDS);
  }

}
