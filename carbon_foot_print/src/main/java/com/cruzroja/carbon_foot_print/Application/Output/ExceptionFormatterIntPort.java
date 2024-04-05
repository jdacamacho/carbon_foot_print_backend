package com.cruzroja.carbon_foot_print.Application.Output;

public interface ExceptionFormatterIntPort {
    public void returnResponseErrorEntityExists(String message);
    public void returnResponseErrorEntityNotFound(String message);
    public void returnResponseBusinessRuleViolated(String message);
    public void returnResponseBadCredentials(String message);
    public void returnResponseBadFormat(String message);
    public void returNoData(String message);
}
