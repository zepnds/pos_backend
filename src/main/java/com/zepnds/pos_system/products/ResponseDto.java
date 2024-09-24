package com.zepnds.pos_system.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private String message;
    private List<T> data;
    private HttpStatus status;

    public void ResponseDTO(String message, List<T> data, HttpStatus status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }
}
