package com.sevenbits.formatter.Readers;

import com.sevenbits.formatter.Exceptions.ReaderException;
/**
 * данный класс реализует интерфейс для StringReaders и FileReaders
 */
public interface IReader {
    char read() throws ReaderException;
}
