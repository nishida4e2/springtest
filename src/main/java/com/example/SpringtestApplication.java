package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class SpringtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtestApplication.class, args);
	}
	
    @RequestMapping(value = "/")
    String hello() {
        return "Hello World!";
    }
    
    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="test") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    
}
