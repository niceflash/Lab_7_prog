package lab7;

import java.util.List;

public class FileTread extends Thread {
    private String filename;
    private List<String> result = null;

    public FileTread(String filename) {
        this.filename = filename;
    }

    @Override
    public synchronized void run() {
        FileReader fl = new FileReader();
        result = fl.readFile(filename);
        }

    public List<String> getResult() {
        return result;
    }
    public String getFilename(){
        return filename;
    }
}