package com.sevenbits.formatter.Readers;

import com.sevenbits.formatter.Exceptions.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;

public class StringReader implements IReader {
    private BufferedReader bufferedReader;

    public StringReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public char read() throws ReaderException {
        try {
            int symbol = bufferedReader.read();
            if (symbol != '\n') {
                return (char) symbol;
            } else {
                bufferedReader.close();
                throw new IndexOutOfBoundsException();
            }
        } catch (IOException e) {
            throw new ReaderException("Error reading");
        }
    }
}
