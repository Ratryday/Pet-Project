package pet.project.service.concurrency;

import pet.project.logger.LoggerExtender;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {

  private CyclicBarrier barrier;

  public Task(CyclicBarrier barrier) {
    this.barrier = barrier;
  }

  private final LoggerExtender log = new LoggerExtender(this.getClass().getName());

  @Override
  public void run() {
    try {
      log.info(Thread.currentThread().getName() + " is waiting");
      barrier.await();
      log.info(Thread.currentThread().getName() + " is released");
    } catch (InterruptedException | BrokenBarrierException e) {
      log.error(e);
    }
  }
}
