package com.example.task10;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Task10Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		Biden biden = context.getBean(Biden.class);
		biden.doPolitic();
		Trump trump = context.getBean(Trump.class);
		trump.doPolitic();
		Merkel merkel = context.getBean(Merkel.class);
		merkel.doPolitic();
	}

}
