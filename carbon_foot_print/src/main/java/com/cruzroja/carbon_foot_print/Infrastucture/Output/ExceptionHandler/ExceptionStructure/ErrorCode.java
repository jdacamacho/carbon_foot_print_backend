package com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.ExceptionStructure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    GENERIC_ERROR("GC-0001", "GENERIC ERROR"),
    ENTITY_EXISTS("GC-0002", "ERROR, ENTITY ALREADY EXISTS"),
    ENTITY_NOT_FOUND("GC-0003", "ERROR, COULDN'T FOUND ENTITY"),
    BUSINESS_RULE_VIOLATION("GC-0004", "ERROR, BUSINESS RULE HAS BEEN VIOLATED"),
    BAD_CREDENTIALS("GC-0005", "ERROR, BAD CREDENTIALS"),
    BAD_FORMAT("GC-0006", "ERROR, BAD FORMAT"),
    NO_DATA("GC-0007", "ERROR, NO DATA");

    private final String code;
    private final String messageKey;
}
