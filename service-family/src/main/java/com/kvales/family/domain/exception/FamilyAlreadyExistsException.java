package com.kvales.family.domain.exception;

public class FamilyAlreadyExistsException extends RuntimeException{

    public FamilyAlreadyExistsException(String field, String value) {
        super("Family already exists with " + field + ": " + value);
    }

}
