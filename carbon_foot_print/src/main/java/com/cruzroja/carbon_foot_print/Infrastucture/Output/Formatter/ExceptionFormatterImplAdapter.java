package com.cruzroja.carbon_foot_print.Infrastucture.Output.Formatter;

import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BadCredentialsException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BadFormatException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BusinessRuleException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.EntityExistsException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.EntityNotFoundException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.NoDataException;

@Service
public class ExceptionFormatterImplAdapter implements ExceptionFormatterIntPort {
    @Override
    public void returnResponseErrorEntityExists(String message) {
        EntityExistsException objException = new EntityExistsException(message);
        throw objException;
    }

    @Override
    public void returnResponseErrorEntityNotFound(String message) {
        EntityNotFoundException objException = new EntityNotFoundException(message);
        throw objException;
    }

    @Override
    public void returnResponseBusinessRuleViolated(String message) {
        BusinessRuleException objException = new BusinessRuleException(message);
        throw objException;
    }

    @Override
    public void returnResponseBadCredentials(String message) {
        BadCredentialsException objException = new BadCredentialsException(message);
        throw objException;
    }

    @Override
    public void returnResponseBadFormat(String message) {
        BadFormatException objException = new BadFormatException(message);
        throw objException;
    }

    @Override
    public void returNoData(String message) {
        NoDataException objException = new NoDataException(message);
        throw objException;
    }
}
