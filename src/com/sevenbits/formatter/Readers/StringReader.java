package com.sevenbits.formatter.Readers;

import com.sevenbits.formatter.Exceptions.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * класс для работы с потоком строки
 */
public class StringReader implements IReader {
    private BufferedReader bufferedReader;

    public StringReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
    /**
     * читает символы в поток
     * @return symbol возвращает прочитанный символ в поток
     */
    public char read() throws ReaderException {
        try {
            int symbol = bufferedReader.read();
            if (symbol != '\n') {
                return (char) symbol;
            } else {
                bufferedReader.close();
                throw new ReaderException("string end");
            }
        } catch (IOException e) {
            throw new ReaderException("Error reading");
        }
    }
}
