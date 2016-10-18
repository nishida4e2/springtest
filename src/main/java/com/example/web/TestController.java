package com.example.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.domain.FoodPrice;
import com.example.service.FoodPriceService;

@Controller
@RequestMapping("/")
public class TestController {
	
    @Autowired
    FoodPriceService foodService;
	
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
	String reg(Model model) {

		/*
		FoodPriceForm fpf = new FoodPriceForm();
		fpf.setName("test");
		model.addAttribute("foodPriceForm", fpf);
		*/
		
		model.addAttribute("foodPriceForm", new FoodPriceForm());
		
		return "reg";
	}
	
	@PostMapping(path = "update")
	String update(FoodPriceForm form) {
		
		System.out.println(form.getName());
		System.out.println(form.getPrice());
		
        FoodPrice fp = new FoodPrice();
        BeanUtils.copyProperties(form, fp);
        
		System.out.println(fp.getName());
		System.out.println(fp.getPrice());
		System.out.println(fp.getId());
        
        foodService.create(fp);
		
		return "redirect:/";
	}

	@PostMapping(path = "back")
	String back() {
		return "redirect:/";
	}

}
