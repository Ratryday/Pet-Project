package pet.project.service;

import pet.project.logger.LoggerExtender;
import pet.project.service.concurrency.Invoker;
import pet.project.service.concurrency.Task;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorTest {

  private final LoggerExtender log = new LoggerExtender(this.getClass().getName());

  private final CyclicBarrier cyclicBarrier;

  public ExecutorTest() {
    this.cyclicBarrier = new CyclicBarrier(3, () -> log.info("All previous tasks are completed"));
    ;
  }

  public void runMethods() {
    /*execute();
    executeService();
    scheduledExecutorService();
    futureTask();*/
    cyclicBarrierTest();
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
}
