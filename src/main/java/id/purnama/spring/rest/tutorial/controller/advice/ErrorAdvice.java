package id.purnama.spring.rest.tutorial.controller.advice;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.beans.Introspector;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
public class ErrorAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public @ResponseBody Map<String, Object> handleConstraintViolation(ConstraintViolationException e, ServletWebRequest request) {
        // emulate Spring DefaultErrorAttributes
        final Map<String, Object> result = new LinkedHashMap<>();
        result.put("timestamp", new Date());
        result.put("status", HttpStatus.BAD_REQUEST.value());
        result.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        result.put("path", request.getRequest().getRequestURI());
        return result;
    }

}
