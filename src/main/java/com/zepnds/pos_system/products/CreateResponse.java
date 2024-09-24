package com.zepnds.pos_system.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponse<T> {
    private String message;
    private HttpStatus status;
    private T data;

    public CreateResponse(String message, T data, HttpStatus status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

}
