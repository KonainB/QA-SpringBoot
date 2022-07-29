package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.cars.BMW;
import com.example.cars.Merc;
import com.example.interfaces.Car;

//@SpringBootApplication
public class DependencyInjection {

	public static void main(String[] args) {
		//ApplicationContext context=SpringApplication.run(DependencyInjection.class, args); 
		/*Merc m=new Merc();//object created and memory allocated
		System.out.println(m.spec());
		BMW b=new BMW();//object created and memory allocated
		System.out.println(b.spec());*/
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(AppConfig.class);
		Car myCar=context.getBean("MyBMW",Car.class);
		System.out.println(myCar.spec());
		
		Car yourCar=context.getBean("MyMerc",Car.class);
		System.out.println(yourCar.spec());
		//Car myCar=new BMW();
		//Car yourCar=new Merc();
		
		                
	}

}
