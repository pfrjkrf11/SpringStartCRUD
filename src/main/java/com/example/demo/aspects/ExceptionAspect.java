package com.example.demo.aspects;

import com.example.demo.dto.ExceptionResponseDto;
import com.example.demo.error.ServerException;
import com.example.demo.error.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAspect {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleException(Exception exception){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto("Не обрабатываемая ошибка", exception.getMessage(), 0);
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(UserException exception){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(exception.getTitle(), exception.getMessage(), 0);
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(ServerException exception){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(exception.getTitle(), exception.getMessage(), 0);
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
