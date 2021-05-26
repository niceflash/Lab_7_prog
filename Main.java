package lab7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        long timeStart;
        long timeEnd;
        String[] names = new String[]{"text.txt", "text1.txt", "text2.txt", "text3.txt"};
        List<FileTread> threads = new ArrayList<>();
        List<String> words = new ArrayList<>();
        List<String> mwords = new ArrayList<String>();
        int count = 0, maxCount = 0;

        FileTread ft;
        for (int i = 0; i < names.length; i++) {

            ft = new FileTread(names[i]);
            threads.add(ft);
            ft.start();
        }

        for(FileTread t : threads){
            try {
                t.join();
                words.addAll(t.getResult());
                System.out.println(words);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        if (words.size() == 0) {
            System.out.println("Все файлы пустые");
            System.exit(0);
        }

        for (int i = 0; i < words.size(); i++) {
            count = 1;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    count++;
                }
            }
            if (count == maxCount) {
                mwords.add(words.get(i));
            }
            if (count > maxCount) {
                maxCount = count;
                mwords.clear();
                mwords.add(words.get(i));
            }
        }
        System.out.println(mwords);
    }
}