package org.example;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.*;


public class FileReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://github.com/PeacockTeam/new-job/releases/download/v1.0/lng-4.txt.gz");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(gzipInputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Обработка каждой строки файла
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

