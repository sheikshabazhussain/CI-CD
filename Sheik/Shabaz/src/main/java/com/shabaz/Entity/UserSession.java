package com.shabaz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserSession {
    
    @Id
    private Long userId;
    private String sessionId;

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
