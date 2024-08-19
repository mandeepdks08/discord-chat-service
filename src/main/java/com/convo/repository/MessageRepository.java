package com.convo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.convo.datamodel.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>, PagingAndSortingRepository<Message, Long> {

	@Query("SELECT m FROM messages m WHERE (m.fromuserid = :userId1 AND m.touserid = :userId2) OR (m.fromuserid = :userId2 AND m.touserid = :userId1")
	public Page<Message> findMessagesBetweenUserIds(String userId1, String userId2, Pageable pageable);
}
