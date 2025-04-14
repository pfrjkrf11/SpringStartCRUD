package com.example.demo.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends Exception {
    private String title;
    private String message;
    private int code;
}
