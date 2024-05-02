package com.example.task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Trump implements Politician{
    @Autowired
    public Trump() {
    }
    @Override
    public void doPolitic(){
        System.out.println("Trump's politics");
    }
}
