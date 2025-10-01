package com.ratryday.pet.postProcessors;

import com.ratryday.pet.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class InjectRandomIntPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    Field[] fields = bean.getClass().getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(InjectRandomInt.class)) {
        field.setAccessible(true);
        InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
        ReflectionUtils.setField(
            field, bean, getRandomIntInRange(annotation.min(), annotation.max()));
      }
    }

    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

  private int getRandomIntInRange(int min, int max) {
    return min + (int) (Math.random() * ((max - min) + 1));
  }
}
