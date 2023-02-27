package com.maraton.exception;

import lombok.Getter;

@Getter
public class MaratonException extends RuntimeException{

    private final ErrorType errorType;

    /**
     * Runtime dan miras aldığımız için hata mesajınızın kendisine iletilmesi gereklidir.
     * @param errorType
     */
    public MaratonException(ErrorType errorType){
        this.errorType=errorType;
    }
    public MaratonException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
