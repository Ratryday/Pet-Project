package com.ratryday.pet.config;

import com.ratryday.pet.postProcessors.InstantiationTracingBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  //@Bean
  public InstantiationTracingBeanPostProcessor instantiationTracingBeanPostProcessor() {
    return new InstantiationTracingBeanPostProcessor();
  }
}
