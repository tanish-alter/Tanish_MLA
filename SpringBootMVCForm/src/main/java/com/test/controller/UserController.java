package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.User;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String homePage()
	{
		return "home";
	}
	
	@GetMapping("/loginform")
	public String userForm(Model model, User user)
	{
		model.addAttribute("info", user);
		return "loginform";
	}
	
	@PostMapping("/submituser")
	public String submitUserForm(
			@Valid
			@ModelAttribute("info") User user,
			BindingResult result)
	{
		if(result.hasErrors())
		{
			return "loginform";
		}
		else
		{
			return "success";
		}
	}
}