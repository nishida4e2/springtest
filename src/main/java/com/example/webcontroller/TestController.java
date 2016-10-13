package com.example.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cont")
public class TestController {
	
    @GetMapping
    String init(Model model) {
    	model.addAttribute("name", "cont");
        return "hello";
    }

}
