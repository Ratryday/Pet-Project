package pet.project;

import pet.project.service.ExecutorTest;

public class Application {

  public static void main(String[] args) throws InterruptedException {
      ExecutorTest executorTest = new  ExecutorTest();
      executorTest.runMethods();
  }
}
