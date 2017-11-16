package com.nagarro.casinoadmin.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.casinoadmin.models.User;
import com.nagarro.casinoadmin.services.UserService;

@Controller
public class CasinoadminController {

	public UserService userService;
	
	@Autowired
	public CasinoadminController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping("/test")
	   public String home(Map<String, Object> model) {
	       model.put("message", "HowToDoInJava Reader !!");
	       return "index";
	   }
	   
	   @RequestMapping("/next")
	   public String next(Map<String, Object> model) {
	       model.put("message", "You are in new page !!");
	       return "next";
	   }
	   
		@GetMapping(value={"/hello"})
		public String hello(Model model,
				@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
			model.addAttribute("name", name);
			return "hello";
		}

		@GetMapping(value={"/home","/"})
		public String home(Model model) {
			return "home";
		}
	   
		@GetMapping("/register")
		public String register(Model model) {
			model.addAttribute("user", new User());
			return "register";
		}

		@GetMapping("/userList")
		public String userList(Model model) {
			model.addAttribute("search", new Search());
			model.addAttribute("users", userService.getAllUsers());
			model.addAttribute("rechargeBalance", new Recharge());
			return "userList";
		}

		@GetMapping(path = "/all")
		public @ResponseBody List<User> getAllUsers(Model model) {
			return userService.getAllUsers();
		}

		
		@PostMapping(path = "/register")
		public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
			if (bindingResult.hasErrors()) {
				return "register";
			}
			System.out.println(userService.addNewUser(user));
			model.addAttribute("user", new User());
			return "register";
		}

		@PostMapping(path = "/userList")
		public String find(@ModelAttribute("search") @Valid Search search, BindingResult bindingResult, Model model) {
			model.addAttribute("users", userService.find(search));
			model.addAttribute("search", new Search());
			model.addAttribute("rechargeBalance", new Recharge());
			return "userList";
		}

		@PostMapping(path = "/recharge")
		public String recharge(@ModelAttribute("rechargeBalance") @Valid Recharge recharge, BindingResult bindingResult,
				Model model) {
			model.addAttribute("users", userService.recharge(recharge.getId(), recharge.getBalance()));
			model.addAttribute("search", new Search());
			model.addAttribute("rechargeBalance", new Recharge());
			return "userList";
		}

		@GetMapping(path = "/user/{id}")
		public @ResponseBody User getUserById(@PathVariable Long id) {
			return userService.getUserById(id);
		}
		
		@GetMapping(path = "/amount/block/{id}/{block_amt}")
		public @ResponseBody User block_amount(@PathVariable Long id ,@PathVariable Long block_amt) {
			return  userService.block_amount(id, block_amt);
		}
		
		@GetMapping(path = "/amount/winning/{id}/{winning_amt}")
		public @ResponseBody User winning_amount(@PathVariable Long id ,@PathVariable Long winning_amt) {
			return userService.winning_amount(id, winning_amt);
		}
		
		

}


