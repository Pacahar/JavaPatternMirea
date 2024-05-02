package com.example.task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Merkel implements Politician{
    @Autowired
    public Merkel() {
    }
    @Override
    public void doPolitic(){
        System.out.println("Merkel's politics");
    }
}
