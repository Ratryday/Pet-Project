package pet.project.service;

import pet.project.service.concurrency.Invoker;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ExecutorTest {

  public static void main(String[] args) {
    execute();
  }

  private static void execute() {
    Executor executor1 = new Invoker();
    executor1.execute(() -> System.out.println("Invoker: " + LocalDateTime.now()));
    System.out.println("Executor: " + LocalDateTime.now());
  }

}
