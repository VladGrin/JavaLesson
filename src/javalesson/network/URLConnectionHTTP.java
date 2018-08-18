package javalesson.network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionHTTP {
    public static void main(String[] args) throws IOException {
        URLConnection connection = new URL("http://www.google.com").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        System.out.println(scanner.next());

        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for(Map.Entry<String, List<String>> entry : headerFields.entrySet()){
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }
    }
}
