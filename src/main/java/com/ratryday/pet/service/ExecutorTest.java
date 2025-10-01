package com.ratryday.pet.service;

import com.ratryday.pet.service.concurrency.Invoker;
import com.ratryday.pet.service.concurrency.Task;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@Service
public class ExecutorTest {

  private final CyclicBarrier cyclicBarrier;
  private final Semaphore semaphore;

  public ExecutorTest() {
    this.cyclicBarrier = new CyclicBarrier(3, () -> log.info("All previous tasks are completed"));
    this.semaphore = new Semaphore(2);
  }

  public void runMethods() throws InterruptedException {
    execute();
    executeService();
    scheduledExecutorService();
    futureTask();
    cyclicBarrierTest();
    Thread t1 = new Thread(this::executeSemaphore, "T4");
    Thread t2 = new Thread(this::executeSemaphore, "T5");
    Thread t3 = new Thread(this::executeSemaphore, "T6");
    t1.start();
    Thread.sleep(100L);
    t2.start();
    Thread.sleep(100L);
    t3.start();
  }

  private void execute() {
    Executor executor1 = new Invoker();
    executor1.execute(() -> log.info("Invoker: " + LocalDateTime.now()));
    log.info("Executor: " + LocalDateTime.now());
  }

  private void executeService() {
    ExecutorService executor2 = Executors.newFixedThreadPool(10);
    executor2.submit(new Task(cyclicBarrier));
    log.info("ExecutorService: " + LocalDateTime.now());
  }

  private void scheduledExecutorService() {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    AtomicInteger futureNum = new AtomicInteger();
    executorService.scheduleAtFixedRate(
        () -> log.info("scheduleAtFixedRate + " + futureNum.getAndIncrement()),
        1,
        3,
        TimeUnit.SECONDS);

    AtomicInteger scheduledFutureNum = new AtomicInteger();
    executorService.scheduleWithFixedDelay(
        () -> log.info("scheduleWithFixedDelay + " + scheduledFutureNum.getAndIncrement()),
        2,
        5,
        TimeUnit.SECONDS);

    executorService.schedule(
        () -> log.info("schedule + " + scheduledFutureNum.getAndIncrement()), 5, TimeUnit.SECONDS);
  }

  private void futureTask() {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    Future<String> future =
        executor.submit(
            () -> {
              Thread.sleep(10000L);
              return "Executed";
            });
    try {
      String futureResult = future.get(1, TimeUnit.SECONDS);
      log.info(futureResult);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      log.error(e);
    }
  }

  public void cyclicBarrierTest() {
    Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
    Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
    Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

    if (!cyclicBarrier.isBroken()) {
      t1.start();
      t2.start();
      t3.start();
    }
  }

  public void executeSemaphore() {
    log.info("Available permit : " + semaphore.availablePermits());

    if (semaphore.tryAcquire()) {
      log.info("Number of threads waiting to acquire: " + semaphore.getQueueLength());
      try {
        log.info("Permit acquired");
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        semaphore.release();
      }
    } else {
      log.info("Permit not acquired");
    }
  }
}
