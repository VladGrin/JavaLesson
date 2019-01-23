package javalesson.patternsgof.structural;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FacadeLesson {
    public static void main(String[] args) throws IOException {
        FileReadFacade fileReadFacade = new FileReadFacade();
        String string = fileReadFacade.readFile("temp.txt");
        System.out.println(string);
    }
}
class FileReadFacade{
    String readFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while ((i = bufferedReader.read()) != -1){
            stringBuilder.append((char)i);
        }
        return stringBuilder.toString();
    }
}