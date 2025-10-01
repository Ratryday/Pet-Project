package com.ratryday.pet.extension;

public class Son extends Parent {

    public void doStuff() {
      System.out.println("Son does stuff");
    }

    @Override
    public void printText() {
        System.out.println("Son printText");
    }
}
