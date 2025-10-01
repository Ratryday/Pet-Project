package com.ratryday.pet.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Date;

//@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("Bean '" + beanName + "' created at: " + new Date());
    System.out.println("Bean: " + bean.toString());
    return bean;
  }
}
