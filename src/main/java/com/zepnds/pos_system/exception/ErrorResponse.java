package com.zepnds.pos_system.exception;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
public class ErrorResponse {
    // Getters and Setters
    private String message;
    private LocalDateTime timestamp;

    // Constructors
    public ErrorResponse(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

}
