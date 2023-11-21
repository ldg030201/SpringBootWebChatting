package com.ldg.webchat.api.repository;

import com.ldg.webchat.api.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Optional<Chat> findById(@Param("id") Integer id);

    List<Chat> findByRoomId(String roomId);
}
