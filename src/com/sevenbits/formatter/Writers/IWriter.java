package com.sevenbits.formatter.Writers;

import com.sevenbits.formatter.Exceptions.WriterException;

public interface IWriter {
    void write(String symbol) throws WriterException;
}
