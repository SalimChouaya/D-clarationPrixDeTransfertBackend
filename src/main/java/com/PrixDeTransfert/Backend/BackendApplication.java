package com.PrixDeTransfert.Backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.PrixDeTransfert.Backend.services", 
        "com.PrixDeTransfert.Backend.models", 
        "com.PrixDeTransfert.Backend.repositories", 
        "com.PrixDeTransfert.Backend.controllers"
})
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
