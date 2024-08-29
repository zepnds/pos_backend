package com.zepnds.pos_system.branch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchCreateResponse {
    @JsonProperty("message")
    private String message;
    @JsonProperty("status")
    private HttpStatus status;
}
