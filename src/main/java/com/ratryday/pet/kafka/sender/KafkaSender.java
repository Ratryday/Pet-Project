package com.ratryday.pet.kafka.sender;

import com.ratryday.pet.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaSender {

  private final KafkaTemplate<String, User> kafkaTemplate;

  public void sendUser(User user, String topicName) {
    log.info("Sending : {}", user);
    log.info("--------------------------------");

    kafkaTemplate.send(topicName, user);
  }
}
