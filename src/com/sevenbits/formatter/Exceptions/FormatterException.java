package com.sevenbits.formatter.Exceptions;
/**
 * Выводит ошибку при работе с символами
 */
public class FormatterException extends Exception{
    public FormatterException(String message) {
        super(message);
    }
}
