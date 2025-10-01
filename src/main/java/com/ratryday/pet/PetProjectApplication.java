package com.ratryday.pet;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.boot.SpringApplication;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
@SpringBootApplication
public class PetProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(PetProjectApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationReady() {
    log.info(
        "\n\n******************************** Application ready at: {} ********************************\n\n",
        LocalTime.now());
  }
}
