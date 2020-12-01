package com.systa.greetinglogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systa.greetinglogin.entity.UserMessage;
import com.systa.greetinglogin.entity.Users;
import com.systa.greetinglogin.repository.UserMessageRepository;
import com.systa.greetinglogin.repository.UsersRepository;

@Service
public class UserMessageService {

	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	UserMessageRepository userMessageRepository;
	
	public List<UserMessage> getUsersMessages(String userName){
		Users user = userRepository.findByUsername(userName);
		return userMessageRepository.findByUser(user);
	}
	
	public void saveUserMessage(String name, String message, String userName){
		Users user = userRepository.findByUsername(userName);
		UserMessage userMessage = UserMessage.builder().name(name).message(message).imageUri("").user(user).build();
		userMessageRepository.save(userMessage);
	}
}
