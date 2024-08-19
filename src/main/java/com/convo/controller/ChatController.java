package com.convo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.convo.datamodel.Message;
import com.convo.handler.MessageHandler;
import com.convo.restmodel.BaseResponse;
import com.convo.restmodel.SendMessageRequest;
import com.convo.restmodel.ShowPersonalMessagesRequest;
import com.convo.restmodel.ShowPersonalMessagesResponse;

@RestController
@RequestMapping("/chat/v1")
public class ChatController {

	@Autowired
	private MessageHandler messageHandler;

	@RequestMapping(value = "/message/send/personal", method = RequestMethod.POST)
	protected ResponseEntity<BaseResponse> sendMessage(@RequestBody SendMessageRequest sendMessageRequest) {
		BaseResponse baseResponse = BaseResponse.builder().build();
		HttpStatus status = null;
		try {
			messageHandler.sendMessage(sendMessageRequest);
			baseResponse.setMessage("Success!");
			status = HttpStatus.OK;
		} catch (Exception e) {
			baseResponse.setErrors(Arrays.asList(e.getMessage()));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(baseResponse, status);
	}

	@RequestMapping(value = "/message/list/personal")
	protected ResponseEntity<ShowPersonalMessagesResponse> showPersonalMessages(
			@RequestBody ShowPersonalMessagesRequest request) {
		ShowPersonalMessagesResponse response = ShowPersonalMessagesResponse.builder().build();
		HttpStatus httpStatus = null;
		try {
			List<Message> messages = messageHandler.showPersonalMessages(request);
			response.setMessages(messages);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response.setErrors(Arrays.asList(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(response, httpStatus);
	}

}
