package com.sevenbits.formatter.Readers;

import com.sevenbits.formatter.Exceptions.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * класс для работы с файловым потоком
 */
public class FileReader implements IReader {
    private BufferedReader bufferedReader;

    public FileReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
    /**
     * осуществляет чтение файла посимвольно в поток
     * @return symbol отправляет символ в поток
     */
    public char read() throws ReaderException {
        try {
            int symbol = bufferedReader.read();
            if (symbol != -1) {
                return (char) symbol;
            } else {
                bufferedReader.close();
                throw new ReaderException("file end");
            }
        } catch (IOException e) {
            throw new ReaderException("Error reading");
        }
    }
}
