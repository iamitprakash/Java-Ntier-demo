package com.example.ntierdemo.utils;

import com.example.ntierdemo.viewmodels.DomainErrorViewModel;
import com.example.ntierdemo.viewmodels.ValidationErrorPageViewModel;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppUtils {
    public static ValidationErrorPageViewModel getValidationErrorPage(MethodArgumentNotValidException exception) {
        List<DomainErrorViewModel> domainErrors = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> new DomainErrorViewModel(fe.getField(), fe.getDefaultMessage()))
                .sorted(Comparator.comparing(DomainErrorViewModel::getField))
                .collect(Collectors.toList());


        return new ValidationErrorPageViewModel(
                exception.getBindingResult().getTarget().getClass().getName(),
                LocalDateTime.now(),
                domainErrors
        );
    }
}
