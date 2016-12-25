package ru.kamagames.exception;

/**
 * Created by Timofey on 25.12.2016.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String s) {
        super(s);
    }
}
