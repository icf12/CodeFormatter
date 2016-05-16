package com.sevenbits.formatter.Exceptions;
/**
 * Выводит exception при чтении строки или файла
 */
public class WriterException extends Exception{
    public WriterException(String message) {
        super(message);
    }
}
