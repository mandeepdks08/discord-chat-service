package com.convo.handler;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.convo.datamodel.Message;
import com.convo.datamodel.MessageReadStatus;
import com.convo.datamodel.User;
import com.convo.repository.MessageRepository;
import com.convo.restmodel.SendMessageRequest;
import com.convo.restmodel.ShowPersonalMessagesRequest;
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

	public List<Message> showPersonalMessages(ShowPersonalMessagesRequest request) {
		User loggedInUser = SystemContextHolder.getLoggedInUser();
		Integer offset = ObjectUtils.firstNonNull(request.getOffset(), 0);
		Integer limit = request.getLimit() != null ? Math.min(request.getLimit(), 100) : 100;
		Pageable pageable = PageRequest.of(offset, limit, Sort.by("processedon").descending());
		return messageRepo.findMessagesBetweenUserIds(request.getFriendUserId(), loggedInUser.getUserId(), pageable)
				.toList();
	}
}
