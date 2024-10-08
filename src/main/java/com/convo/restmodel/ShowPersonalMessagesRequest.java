package com.convo.restmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowPersonalMessagesRequest {
	private String friendUserId;
	private Integer offset;
	private Integer limit;
}
