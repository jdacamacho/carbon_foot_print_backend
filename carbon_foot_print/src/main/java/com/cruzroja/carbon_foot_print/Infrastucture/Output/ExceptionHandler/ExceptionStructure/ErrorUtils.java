package com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure;

public final class ErrorUtils {

    ErrorUtils() {

    }
  
    public static Error createError(final String errorCode, final String messageKey, final Integer httpCode) {
      final Error error = new Error();
      error.setErrorCode(errorCode);
      error.setMessage(messageKey);
      error.setHttpCode(httpCode);
      return error;
    }
}
