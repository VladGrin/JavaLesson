package javalesson.stepic;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class US_ASCII {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("out.txt");

        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        writer.write("Проверка связи");
        writer.flush();
        writer.close();
    }
}
