package br.com.rafael.moneyapi.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MoneyApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public MoneyApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String messageReturnedForUser = messageSource.getMessage("messages.properties", null,
                LocaleContextHolder.getLocale());
        String messageReturnedForDeveloper = ex.getCause().toString();

        List<Error> errorList = List.of(new Error(messageReturnedForUser, messageReturnedForDeveloper));


        return handleExceptionInternal(ex, errorList, headers, HttpStatus.BAD_REQUEST,
                request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> errorList = errorListCreator(ex.getBindingResult());

        return handleExceptionInternal(ex, errorList, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAccessException(WebRequest request,
                                                                       EmptyResultDataAccessException ex) {
        String messageReturnedForUser = messageSource.getMessage("resource.not-found", null,
                LocaleContextHolder.getLocale());
        String messageReturnedForDeveloper = ex.toString();

        List<Error> errorList = List.of(new Error(messageReturnedForUser, messageReturnedForDeveloper));

        return handleExceptionInternal(ex, errorList, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private List<Error> errorListCreator(BindingResult bindingResult) {
        List<Error> errorList = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(fieldError -> errorList.add(new Error(
                messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()), fieldError.toString())));
        return errorList;
    }

    public static final class Error {
        private final String messageForUser;
        private final String messageForDeveloper;

        public Error(String messageForUser, String messageForDeveloper) {
            this.messageForUser = messageForUser;
            this.messageForDeveloper = messageForDeveloper;
        }

        public String getMessageForUser() {
            return messageForUser;
        }

        public String getMessageForDeveloper() {
            return messageForDeveloper;
        }
    }

}
