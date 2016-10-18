package com.example.web;

import java.util.List;

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

	@GetMapping
	String init(Model model) {
		List<FoodPrice> foodList = foodService.findAll();
		model.addAttribute("foodModel", foodList);
		return "menulist";
	}

	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, Model model) {
		FoodPrice fp = foodService.findOne(id);
		model.addAttribute("foodPriceForm", fp);
		return "reg2";
	}
	
	@PostMapping(path = "editupdate")
	String editupdate(Integer id, FoodPriceForm form) {

		System.out.println(form.getName());
		System.out.println(form.getPrice());

		FoodPrice fp = new FoodPrice();
		BeanUtils.copyProperties(form, fp);
		fp.setId(id);

		System.out.println(fp.getName());
		System.out.println(fp.getPrice());
		System.out.println(fp.getId());

		foodService.create(fp);

		return "redirect:/";
	}
	
	@PostMapping(path = "delete")
	String delete(@RequestParam Integer id) {
		foodService.delete(id);
		return "redirect:/";
	}

	@PostMapping(path = "reg")
	String reg(Model model) {
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
