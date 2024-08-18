package com.convo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.convo.handler.MessageHandler;
import com.convo.restmodel.SendMessageRequest;

@RestController
@RequestMapping("/chat/v1")
public class ChatController {
	
	@Autowired
	private MessageHandler messageHandler;
	
	@RequestMapping(value = "/message/send", method = RequestMethod.POST)
	protected void sendMessage(@RequestBody SendMessageRequest sendMessageRequest) {
		
	}

}
