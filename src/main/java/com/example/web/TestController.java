package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TestController {

	String viewtest;

	@GetMapping
	String init(Model model) {
		// viewtest = "1";
		model.addAttribute("name", viewtest);
		return "menulist";
	}

	@PostMapping(path = "edit")
	String edit(Model model) {
		// model.addAttribute("name", "edit_test");
		// return "hello";
		viewtest = "2";
		return "redirect:/";
	}

	@PostMapping(path = "reg")
	String reg() {
		return "reg";
	}

	@PostMapping(path = "back")
	String back() {
		return "redirect:/";
	}

}
