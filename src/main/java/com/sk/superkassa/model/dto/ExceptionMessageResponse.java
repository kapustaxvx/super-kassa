package com.sk.superkassa.model.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
public class ExceptionMessageResponse {
    private String result;
    private String message;
    private LocalDateTime timestamp;

    public ExceptionMessageResponse(String result, String message, LocalDateTime timestamp) {
        this.result = result;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}