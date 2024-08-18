package com.convo.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class User extends DbBaseModel {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String name;
	private String email;
	private String phone;
	private Boolean enabled;
}