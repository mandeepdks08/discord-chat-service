package com.convo.handler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.convo.datamodel.Message;
import com.convo.datamodel.MessageReadStatus;
import com.convo.datamodel.User;
import com.convo.repository.MessageRepository;
import com.convo.restmodel.SendMessageRequest;
import com.convo.util.SystemContextHolder;

@Component
public class MessageHandler {

	@Autowired
	private MessageRepository messageRepo;

	public void sendMessage(SendMessageRequest sendMessageRequest) {
		User loggedInUser = SystemContextHolder.getLoggedInUser();
		Message message = Message.builder().fromUserId(loggedInUser.getUserId())
				.toUserId(sendMessageRequest.getSendToUserId()).messageReadStatus(MessageReadStatus.DELIVERED)
				.createdOn(LocalDateTime.now()).processedOn(LocalDateTime.now()).build();
		messageRepo.save(message);
		// TODO: Send notification to receiver
	}
}
