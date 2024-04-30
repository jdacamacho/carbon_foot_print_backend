package com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure.ErrorCode;

import lombok.Getter;

@Getter
public class ExpiredTokenException extends RuntimeException {
    private final String messageKey;
    private final String code;

    public ExpiredTokenException(ErrorCode code){
      super(code.getCode());
      this.messageKey = code.getMessageKey();
      this.code = code.getCode();
    }

    public ExpiredTokenException(final String message){
      super(message);
      this.messageKey = ErrorCode.TOKEN_EXPIRED.getMessageKey();
      this.code = ErrorCode.TOKEN_EXPIRED.getCode();
    }
}
