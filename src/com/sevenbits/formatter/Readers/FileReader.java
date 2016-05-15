package com.sevenbits.formatter.Readers;

import com.sevenbits.formatter.Exceptions.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader implements IReader {
    private BufferedReader bufferedReader;

    public FileReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public char read() throws ReaderException {
        try {
            int symbol = bufferedReader.read();
            if (symbol != -1) {
                return (char) symbol;
            } else {
                bufferedReader.close();
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ReaderException("Error reading");
        }
    }
}
