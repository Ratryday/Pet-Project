package com.ratryday.pet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class BeanConfiguration {

  //@Bean
  public InstantiationTracingBeanPostProcessor instantiationTracingBeanPostProcessor() {
    return new InstantiationTracingBeanPostProcessor();
  }
}
