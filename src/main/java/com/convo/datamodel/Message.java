package com.convo.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "messages")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Message extends DbBaseModel {
	@Column(name = "fromuserid")
	private String fromUserId;
	@Column(name = "touserid")
	private String toUserId;
	@Column(name = "messagereadstatus")
	@Enumerated(EnumType.STRING)
	private MessageReadStatus messageReadStatus;
}
