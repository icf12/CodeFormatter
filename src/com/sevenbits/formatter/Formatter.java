package com.sevenbits.formatter;

import com.sevenbits.formatter.Exceptions.FormatterException;
import com.sevenbits.formatter.Exceptions.ReaderException;
import com.sevenbits.formatter.Exceptions.WriterException;
import com.sevenbits.formatter.Readers.IReader;
import com.sevenbits.formatter.Writers.IWriter;
/**
 * Данный класс осуществляет форматирование входящих символов
 */
public class Formatter {
    private char previousChar = ' ';
    private int indents = 0;
    /**
     * Принимает потоки и отправляет для обработки
     * @param reader поток для чтения
     * @param writer поток для записи
     */
    public void format(IReader reader, IWriter writer) throws FormatterException{
        while (true) {
            try {
                char symbol = reader.read();
                String result = formatSymbol(symbol);
                writer.write(result);
            } catch (ReaderException e) {
                break;
            } catch (Exception e) {
                throw new FormatterException("formatter error");
            }
        }
    }
    /**
     * Метод проверяет и обрабатывает входящие символы
     * @param symbol принимает символ для обработки
     * @return string возвращает строку для записи
     */
    public String formatSymbol(char symbol) {
        String result = "";
        switch (symbol) {
            case '{':
                if (previousChar != ' ') {
                    result += " ";
                }
                result += symbol;
                indents += 4;
                result += "\n";
                previousChar = '\n';
                break;
            case '\n':
                break;
            case ';':
                result += symbol;
                result += "\n";
                previousChar = '\n';
                break;
            case ' ':
                if (previousChar != ' ' && previousChar != ';' && previousChar != '{'
                        && previousChar != '}' && previousChar != '\n'){
                    result += symbol;
                    previousChar = symbol;
                }
                break;
            case '}':
                indents -= 4;
                for (int j = 0; j < indents; j++){
                    result += " ";
                }
                result += symbol;
                result += "\n";
                previousChar = '\n';
                break;
            case '\r':
                break;
            default:
                if (previousChar == '\n' || previousChar == ';'
                        || previousChar == '{' || previousChar == '}') {
                    for (int j = 0; j < indents; j++){
                        result += " ";
                    }
                }
                result += symbol;
                previousChar = symbol;
                break;
        }
        return result;
    }
}