package com.systa.greetinglogin.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.systa.greetinglogin.service.UserMessageService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class GreetingController {

	@Autowired
	UserMessageService userMessageService;
	
	@GetMapping("/")
	public String greeting(Authentication authentication, Model model){
		log.info("user name is {}", authentication.getName());
		model.addAttribute("messages", userMessageService.getUsersMessages(authentication.getName()));
		return "dashboard";
	}
	
	@PostMapping("/postGreeting")
	public String post(@RequestParam(name="file", required=false) MultipartFile file,
         @RequestParam String name, @RequestParam String message, Model model, Authentication authentication) throws IOException {
		userMessageService.saveUserMessage(name, message, authentication.getName());
        model.addAttribute("name", name);        
		return "redirect:/";
  }
}
