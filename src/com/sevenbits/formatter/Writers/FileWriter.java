package com.sevenbits.formatter.Writers;

import com.sevenbits.formatter.Exceptions.WriterException;

import java.io.BufferedWriter;
import java.io.IOException;
/**
 * Осуществляет запись в файл
 */
public class FileWriter implements IWriter{
    private BufferedWriter bufferedWriter;

    public FileWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }
    /**
     * Записывает входящие строки построчно в файл
     * @param symbol входящая строка для записи
     */
    public void write(String symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Error writing");
        }
    }
}
