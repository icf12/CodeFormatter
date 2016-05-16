package com.sevenbits.formatter.Writers;

import com.sevenbits.formatter.Exceptions.WriterException;
/**
 * данный класс реализует интерфейс для StringWriter и FileWriter
 */
public interface IWriter {
    void write(String symbol) throws WriterException;
}
