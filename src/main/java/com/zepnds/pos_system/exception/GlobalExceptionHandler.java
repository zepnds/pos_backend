package com.zepnds.pos_system.exception;

import com.zepnds.pos_system.auth.AuthErrorException;

import com.zepnds.pos_system.branch.BranchErrorException;
import com.zepnds.pos_system.merchant.MerchantErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthErrorException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationErrorException(AuthErrorException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(MerchantErrorException.class)
    public ResponseEntity<ErrorResponse> handleMerchantErrorException(MerchantErrorException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(BranchErrorException.class)
    public ResponseEntity<ErrorResponse> handleBranchErrorException(BranchErrorException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
