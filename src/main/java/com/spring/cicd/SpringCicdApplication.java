package com.spring.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCicdApplication {

	@GetMapping("/")
    public String displayMessage(){
        return "Jenkins -  demo whith Springboot";
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringCicdApplication.class, args);
	}

}
