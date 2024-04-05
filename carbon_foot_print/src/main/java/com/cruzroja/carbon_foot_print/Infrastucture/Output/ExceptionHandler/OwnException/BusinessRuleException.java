package com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure.ErrorCode;

public class BusinessRuleException extends ManageRunTimeException{

    private static final String EXCEPTION_FORMAT = "%s - Business rule violation: %s";
    private final String businessRule;

    public BusinessRuleException(final String businessRule){
        super(ErrorCode.BUSINESS_RULE_VIOLATION);
        this.businessRule = businessRule;
    }

    @Override
    public String formatException() {
        return String.format(EXCEPTION_FORMAT, errorCode.getCode(), businessRule);
    }
    
}
