package com.RBAC_System.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ApiResponse {
    private String message;
    private boolean success;

    public ApiResponse() {
    }


    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }


}
