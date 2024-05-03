package com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure.ErrorCode;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure.ErrorUtils;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BadCredentialException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BadFormatException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BusinessRuleException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.EntityExistsException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.EntityNotFoundException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.NoAccessException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.NoDataException;

import io.jsonwebtoken.ExpiredJwtException;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure.Error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class RestApiException {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                    final Exception ex, final Locale locale) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.GENERIC_ERROR.getCode(),
                                        ErrorCode.GENERIC_ERROR.getMessageKey(),
                                        HttpStatus.INTERNAL_SERVER_ERROR.value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Error> handleExpiredJwtException(final HttpServletRequest req,
                                                           final ExpiredJwtException ex, final Locale locale) {
        final Error error = ErrorUtils
                .createError(ErrorCode.TOKEN_EXPIRED.getCode(),
                            ErrorCode.TOKEN_EXPIRED.getMessageKey(),
                            HttpStatus.UNAUTHORIZED.value())
                .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Error> handleAccessDeniedException(final HttpServletRequest req,
                        final AccessDeniedException ex, final Locale locale) {
        final Error error = ErrorUtils
                            .createError(ErrorCode.NO_ACCESS.getCode(),
                                            ErrorCode.NO_ACCESS.getMessageKey(),
                                            HttpStatus.FORBIDDEN.value())
                                            .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                    final EntityExistsException ex) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.ENTITY_EXISTS.getCode(),
                                        String.format("%s, %s", ErrorCode.ENTITY_EXISTS.getMessageKey(),
                                        ex.getMessage()),
                                        HttpStatus.NOT_ACCEPTABLE.value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<Error> handleNoDataException(final HttpServletRequest req,
                    final NoDataException ex) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.NO_DATA.getCode(),
                                        String.format("%s, %s", ErrorCode.NO_DATA.getMessageKey(),
                                        ex.getMessage()),
                                        HttpStatus.NOT_ACCEPTABLE.value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleNotFoundException(final HttpServletRequest req,
                    final EntityNotFoundException ex, final Locale locale) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.ENTITY_NOT_FOUND.getCode(),
                                        String.format("%s, %s",
                                        ErrorCode.ENTITY_NOT_FOUND.getMessageKey(),
                                        ex.getMessage()),
                                        HttpStatus.NOT_FOUND.value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Error> handleBadCredentialsException(final HttpServletRequest req,
                    final BadCredentialsException ex, final Locale locale) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.BAD_CREDENTIALS.getCode(),
                                        String.format("%s, %s",
                                        ErrorCode.BAD_CREDENTIALS.getMessageKey(),
                                        ex.getMessage()),
                                        HttpStatus.NOT_FOUND .value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialException.class)
    public ResponseEntity<Error> handleBadCredentialException(final HttpServletRequest req,
                    final BadCredentialException ex, final Locale locale) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.BAD_CREDENTIALS.getCode(),
                                        String.format("%s, %s",
                                        ErrorCode.BAD_CREDENTIALS.getMessageKey(),
                                        ex.getMessage()),
                                        HttpStatus.NOT_FOUND .value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoAccessException.class)
    public ResponseEntity<Error> handleNoAccessException(final HttpServletRequest req,
                    final NoAccessException ex, final Locale locale) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.NO_ACCESS.getCode(),
                                        String.format("%s, %s",
                                        ErrorCode.NO_ACCESS.getMessageKey(),
                                        ex.getMessage()),
                                        HttpStatus.NOT_ACCEPTABLE .value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BadFormatException.class)
    public ResponseEntity<Error> handleBadFormatException(final HttpServletRequest req,
                    final BadFormatException ex, final Locale locale) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.BAD_FORMAT.getCode(),
                                        String.format("%s, %s",
                                        ErrorCode.BAD_FORMAT.getMessageKey(),
                                        ex.getMessage()),
                                        HttpStatus.NOT_ACCEPTABLE.value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Error> handleBusinessRuleException(final HttpServletRequest req,
                    final BusinessRuleException ex, final Locale locale) {
        final Error error = ErrorUtils
                        .createError(ErrorCode.BUSINESS_RULE_VIOLATION.getCode(), ex.formatException(),
                                        HttpStatus.BAD_REQUEST.value())
                                        .setUrl(req.getRequestURL().toString()).setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
                String campo = ((FieldError) error).getField();
                String mensajeDeError = error.getDefaultMessage();
                errores.put(campo, mensajeDeError);
        });

        return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(e.getMessage(),
                        HttpStatus.BAD_REQUEST);
    }

}
