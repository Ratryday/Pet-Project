package com.ratryday.pet.service;

import com.ratryday.pet.annotations.InjectRandomInt;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @InjectRandomInt(min = 20, max = 100)
    private Integer value;

}
