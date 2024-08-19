package com.convo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.convo.datamodel.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>, PagingAndSortingRepository<Message, Long> {
	public Page<Message> findByToUserId(String toUserId, Pageable pageable);
}
