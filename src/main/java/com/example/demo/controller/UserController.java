package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	private UserRepository userRepository;
	
	@GetMapping("/info/{id}")
	public String getInfo(@PathVariable("id") int id, Model model) {
		model.addAttribute("user",userRepository.findById(id));
		return "info";
	}
	

	@GetMapping("/create")
	public String createUser() {
		return "user_form";
	}

	@PostMapping("/add")
	public String addUser(@ModelAttribute(name = "user") User user, Model model) {
		userRepository.save(user);
		return "redirect:/users/all";
	}

	@GetMapping("/all")
	public String users(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}
}
