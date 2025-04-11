package com.example.security.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String code;
    private String message;
    private Object data;

    public Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
