package com.example.task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Biden implements Politician{
    @Autowired
    public Biden() {
    }
    @Override
    public void doPolitic(){
        System.out.println("Biden's politics");
    }
}
