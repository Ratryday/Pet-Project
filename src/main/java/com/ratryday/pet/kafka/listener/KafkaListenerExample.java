package com.ratryday.pet.kafka.listener;

import com.ratryday.pet.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListenerExample {

  @KafkaListener(
      topics = "topic-",
      groupId = "user-group",
      containerFactory = "userKafkaListenerContainerFactory")
  void listenerWithMessageConverter(User user) {
    log.info("Received message through MessageConverterUserListener [{}]", user);
  }
}
