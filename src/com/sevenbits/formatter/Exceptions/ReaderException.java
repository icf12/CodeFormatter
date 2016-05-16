package com.sevenbits.formatter.Exceptions;
/**
 * Выводит ошибку при чтении символов
 */
public class ReaderException extends Exception {
    public ReaderException(String message) {
        super(message);
    }
}
