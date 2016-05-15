package com.sevenbits.formatter.Writers;

import com.sevenbits.formatter.Exceptions.WriterException;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter implements IWriter{
    private BufferedWriter bufferedWriter;

    public FileWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void write(String symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Error writing");
        }
    }
}
