package com.convo.restmodel;

import java.util.List;

import com.convo.datamodel.Message;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ShowPersonalMessagesResponse extends BaseResponse {
	private List<Message> messages;
}
