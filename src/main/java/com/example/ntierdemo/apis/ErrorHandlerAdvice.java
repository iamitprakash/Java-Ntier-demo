package com.example.ntierdemo.apis;

import com.example.ntierdemo.exceptions.RecordNotFoundException;
import com.example.ntierdemo.utils.AppUtils;
import com.example.ntierdemo.viewmodels.ValidationErrorPageViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ErrorHandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorPageViewModel> handleValidationException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(AppUtils.getValidationErrorPage(exception));
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRecordNotFoundException(RecordNotFoundException exception) {
        Map<String, String> map = Map.of("message", exception.getMessage());
        return ResponseEntity.badRequest().body(map);
    }
}
