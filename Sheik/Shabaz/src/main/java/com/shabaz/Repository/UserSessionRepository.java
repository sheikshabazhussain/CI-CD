package com.shabaz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shabaz.Entity.UserSession;

import jakarta.transaction.Transactional;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    UserSession findByUserId(Long userId);
    
    @Transactional
    void deleteBySessionId(String sessionId);
}
