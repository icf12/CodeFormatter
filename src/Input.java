import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private ArrayList<Character> mass = new ArrayList<Character>();

    public String getFileName(String userMessage) {
        Scanner reader = new Scanner(System.in);
        System.out.println(userMessage);
        return reader.next();
    }

    public ArrayList<Character> fileToArray(String inputFileName) throws IOException {
        File file = new File(inputFileName);
        if (!file.exists() && file.isFile() && file.canRead()) {
            throw new FileNotFoundException();
        }
        FileInputStream fis = new FileInputStream(file);
        System.out.println("Start Formatter");
        while (fis.available() > 0) {
            mass.add((char) fis.read());
        }
        return mass;
    }
}