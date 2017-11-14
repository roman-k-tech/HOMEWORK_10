package TASK_01_02;

import sun.invoke.empty.Empty;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {

    private TreeMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new TreeMap<>();
        dictionary.put("i", "я");
        dictionary.put("have", "мати");
        dictionary.put("cat", "кіт");
        dictionary.put("home", "дім");
        dictionary.put("live", "жити");
        dictionary.put("a", "");
        dictionary.put("in", "в");
        dictionary.put("", "");
        dictionary.put("", "");
        dictionary.put("", "");
        dictionary.put("", "");
        dictionary.put("", "");
        dictionary.put("", "");
        dictionary.put("", "");
        dictionary.put("", "");
    }

    public TreeMap<String, String> getDictionary() {
        return this.dictionary;
    }

    public void saveToFile() {
        try (PrintWriter printWriter = new PrintWriter(new File("Dictionary.map"))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                printWriter.print(entry.getKey() + " " + entry.getValue());
                printWriter.println();
            }
        }catch (FileNotFoundException e) {e.printStackTrace();}

    }

    public TreeMap<String, String> readFromFile() {

        try (Scanner scanner = new Scanner(new File("Dictionary.map"))) {

            TreeMap<String, String> read = new TreeMap<>();
            while (scanner.hasNext()) {
                read.put(scanner.next(), scanner.next());
            }
            this.dictionary = read;
            return this.dictionary;

        } catch (FileNotFoundException e) {e.printStackTrace();}
        finally
        {
            return null;
        }
    }
}
