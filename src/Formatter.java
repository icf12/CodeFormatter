import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Formatter {
    public void formatter(ArrayList<Character> ms, String address) {
        File file = new File(address);
        try {
            FileOutputStream fos = new FileOutputStream(file, false);
            int bs = 0;
            char previousChar = ms.get(0);
            fos.write(ms.get(0));
            for (int i = 1; i < ms.size(); i++) {
                switch (ms.get(i)) {
                    case '{':
                        if (previousChar != ' ') {
                            fos.write(' ');
                        }
                        fos.write(ms.get(i));
                        bs = bs + 4;
                        fos.write('\n');
                        previousChar = '\n';
                        break;
                    case '\n':
                        break;
                    case ';':
                        fos.write(ms.get(i));
                        fos.write('\n');
                        previousChar = '\n';
                        break;
                    case ' ':
                        if (previousChar != ' ' && previousChar != ';' && previousChar != '{'
                                && previousChar != '}' && previousChar != '\n'){
                            fos.write(ms.get(i));
                            previousChar = ms.get(i);
                        }
                        break;
                    case '}':
                        bs = bs - 4;
                        for (int j = 0; j < bs; j++){
                            fos.write(' ');
                        }
                        fos.write(ms.get(i));
                        fos.write('\n');
                        previousChar = '\n';
                        break;
                    case '\r':
                        break;
                    default:
                        if (previousChar == '\n' || previousChar == ';'
                                || previousChar == '{' || previousChar == '}') {
                            for (int j = 0; j < bs; j++){
                                fos.write(' ');
                            }
                        }
                        fos.write(ms.get(i));
                        previousChar = ms.get(i);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
