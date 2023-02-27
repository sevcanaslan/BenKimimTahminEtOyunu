package com.maraton.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    /**
     *
     */
    BAD_REQUEST_ERROR(1201,"Geçersiz parametre girişi yaptınız!",BAD_REQUEST),
    INTERNAL_ERROR(3000,"sunucuda beklenmeyen hata", INTERNAL_SERVER_ERROR),
    KULLANICI_BULUNAMADI(2301,"Aradığınız id'ye ailt kullanıcı bulunamamıştır",INTERNAL_SERVER_ERROR),
    KULLANICI_KAYITLI (1234,"Girdiğniz kullanıcı sistemde kayıtlıdır",INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
