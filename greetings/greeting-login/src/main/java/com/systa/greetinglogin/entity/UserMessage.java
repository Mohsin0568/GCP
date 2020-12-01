package com.systa.greetinglogin.entity;

import javax.persistence.*;
import lombok.*;

@Entity(name="user_messages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String message;
	
	private String imageUri;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
}

