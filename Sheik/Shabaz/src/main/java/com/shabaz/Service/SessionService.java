package com.shabaz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabaz.Entity.UserSession;
import com.shabaz.Repository.UserSessionRepository;

import jakarta.transaction.Transactional;

@Service
public class SessionService {

    @Autowired
    private UserSessionRepository userSessionRepository;

    public boolean isUserLoggedIn(Long userId) {
        UserSession session = userSessionRepository.findByUserId(userId);
        return session != null; // Return true if a session exists
    }

    public void storeSession(Long userId, String sessionId) {
        UserSession userSession = new UserSession();
        userSession.setUserId(userId);
        userSession.setSessionId(sessionId);
        userSessionRepository.save(userSession);
    }

    @Transactional
    public void removeSession(String sessionId) {
        userSessionRepository.deleteBySessionId(sessionId);
    }
}
