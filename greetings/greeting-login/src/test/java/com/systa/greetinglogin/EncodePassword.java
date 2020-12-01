package com.systa.greetinglogin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class EncodePassword {

	@Autowired
	PasswordEncoder encoder;
	
	@Test
	public void encodePassword(){
		System.out.println(encoder.encode("pass"));
	}
}
