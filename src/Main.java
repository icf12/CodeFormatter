import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Formatter formatter = new Formatter();
        String inputFileName = input.getFileName("Entry file address for read");
        String outputFileName = input.getFileName("Entry file address for save");
        ArrayList<Character> forFormatter;
        try {
            forFormatter = input.fileToArray(inputFileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Error occurred while reading file");
            return;
        }
        formatter.formatter(forFormatter, outputFileName);
    }
}