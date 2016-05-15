package com.sevenbits.formatter.Writers;

public class StringWriter implements IWriter {
    public void write(String symbol) {
        System.out.print(symbol);
    }
}
