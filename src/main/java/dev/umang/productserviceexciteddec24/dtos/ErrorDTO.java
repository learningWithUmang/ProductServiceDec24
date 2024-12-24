package dev.umang.productserviceexciteddec24.dtos;

import lombok.Getter;


public class ErrorDTO {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
