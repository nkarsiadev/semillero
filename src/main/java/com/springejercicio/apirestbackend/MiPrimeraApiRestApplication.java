package com.springejercicio.apirestbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiPrimeraApiRestApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(MiPrimeraApiRestApplication.class, args).getBeanDefinitionNames();
		/*for(String str: beanDefinitionNames){
			System.out.println(str);
		}*/
	}
}
