package lab7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public synchronized List<String> readFile(String filename){
        long timeStart;
        long timeEnd;
        timeStart = System.nanoTime();
        String line = null, word = "";
        int count = 0, maxCount = 0;
        List<String> words = new ArrayList<String>();

        java.io.FileReader file = null;
        try {
            file = new java.io.FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(file);

        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String string[] = line.split("[,.\\s]+");
            for (String s : string) {
                words.add(s);
            }
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeEnd = System.nanoTime();
        return words;
    }
}
