package com.sevenbits.formatter.Readers;

import com.sevenbits.formatter.Exceptions.ReaderException;

public interface IReader {
    char read() throws ReaderException;
}
