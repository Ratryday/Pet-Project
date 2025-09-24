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

}
