package com.caiomacedo.illegalityleague.exceptions.handler;

import java.time.LocalDateTime;

public class ErrorMessage {

    private final LocalDateTime timestamp;
    private final String message;

    public ErrorMessage(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
}
