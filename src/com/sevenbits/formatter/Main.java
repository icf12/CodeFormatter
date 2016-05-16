package com.sevenbits.formatter;

import com.sevenbits.formatter.Readers.FileReader;
import com.sevenbits.formatter.Readers.StringReader;
import com.sevenbits.formatter.Writers.FileWriter;
import com.sevenbits.formatter.Writers.StringWriter;
import java.io.*;
import java.util.Scanner;
/**
 * Осуществляет процесс выбора способа ввода чтения
 * в зависимости от выбора считывает адреса для чтения и сохранения файла
 */
public class Main {
    private static Formatter formatter = new Formatter();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Select input method. entry 1 - read from a file, 2 - for manual input");
        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                String inputFileName = getFileName("Entry file address for read");
                String outputFileName = getFileName("Entry file address for save");
                BufferedReader bufferedReader;
                BufferedWriter bufferedWriter;
                bufferedReader = new BufferedReader(new java.io.FileReader(inputFileName));
                bufferedWriter = new BufferedWriter(new java.io.FileWriter(outputFileName));
                FileReader reader = new FileReader(bufferedReader);
                FileWriter fileWriter = new FileWriter(bufferedWriter);
                formatter.format(reader, fileWriter);
                bufferedWriter.close();
                System.out.println("File end");
            } else if (choice == 2) {
                System.out.println("Enter the string");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                StringReader reader = new StringReader(bufferedReader);
                StringWriter stringWriter = new StringWriter();
                formatter.format(reader, stringWriter);
                System.out.println("\nString end");
            } else {
                System.out.println("Error entry");
            }
        } catch (Exception e) {
            System.out.println("Entry error");
        }
    }
    /**
     * Ввод адресов для чтения и записи файла
     * @param userMessage сообщение для определения ввода вывода
     * @return текст введенный в консоль
     */
    public static String getFileName(String userMessage) {
        System.out.println(userMessage);
        return scanner.next();
    }
}