package com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure.ErrorCode;

import lombok.Getter;

@Getter
public class NoDataException extends RuntimeException{
    private final String mesageKey;
    private final String code;

    public NoDataException(ErrorCode code){
        super(code.getCode());
        this.mesageKey = code.getMessageKey();
        this.code = code.getCode();
    }

    public NoDataException(final String message){
        super(message);
        this.mesageKey = ErrorCode.BAD_FORMAT.getMessageKey();
        this.code = ErrorCode.BAD_FORMAT.getCode();
    }
}
