package com.systa.greetinglogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systa.greetinglogin.entity.UserMessage;
import com.systa.greetinglogin.entity.Users;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

	public List<UserMessage> findByUser(Users user);
}
