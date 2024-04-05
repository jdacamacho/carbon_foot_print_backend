package com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class ManageRunTimeException  extends RuntimeException{
    protected ErrorCode errorCode;
    
    public abstract String formatException();
}
