package com.sevenbits.formatter.Writers;
/**
 * Осуществляет вывод обработанного кода на экран
 */
public class StringWriter implements IWriter {
    /**
     * Выводит обработанный код на экран
     * @param symbol принимает строку для вывода
     */
    public void write(String symbol) {
        System.out.print(symbol);
    }
}
