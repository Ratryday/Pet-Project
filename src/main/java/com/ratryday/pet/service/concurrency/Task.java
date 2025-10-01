package com.ratryday.pet.service.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Task implements Runnable {

  private CyclicBarrier barrier;

  public Task(CyclicBarrier barrier) {
    this.barrier = barrier;
  }
  @Override
  public void run() {
    try {
      log.info(Thread.currentThread().getName() + " is waiting");
      barrier.await();
      log.info(Thread.currentThread().getName() + " is released");
    } catch (InterruptedException | BrokenBarrierException e) {
      log.error(e.getLocalizedMessage());
    }
  }
}
