package TASK_01_02;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class TASK_01 {
    static private TASK_01 task_01;
    private Dictionary dict1;
    private String inputFileName = "English.in";
    private String translatedFileName = "Ukrainian.out";


    public TASK_01() {
        this.dict1 = new Dictionary();
    }

    public static void main(String[] args) throws IOException {
        task_01 = new TASK_01();
        task_01.input();
    }

    public void translate() {
        File inputFile = new File(inputFileName);
        File translatedFile = new File(translatedFileName);
        TreeMap<String, String> dictionary = dict1.getDictionary();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName)); PrintWriter printWriter = new PrintWriter(translatedFile)) {
            String input;

            Stream<String> wordStream = bufferedReader.lines().map(n -> n.split("\\W+")).flatMap(n -> Arrays.stream(n));

            Function<String, String> func = n -> {
                String translated;
                translated = dictionary.get(n.toLowerCase());
                if (translated == null)
                    return (String) n;
                else
                    return translated;
            };

//            ArrayList<String> array = (ArrayList<String>) wordStream.map(func).collect(Collectors.toList());

//            for (String word : array)
//            {
//                printWriter.print(word + " ");
//            }

            wordStream.map(func).forEach(n -> printWriter.print(n + " "));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void input () throws IOException {
        boolean exited = false;
        String input = null;
        Scanner s = new Scanner(System.in);
        while (!exited) {
            System.out.println("COMMANDS:");
            System.out.println("1 - Translate file");
            System.out.println("2 - Read Dictionary from file");
            System.out.println("3 - Save Dictionary to file");
            System.out.println("0 - Exit\n");

            System.out.print("Input command: ");
            input = s.next();

            switch (input.charAt(0)) {
                case '0':
                    System.out.println("Exited.");
                    exited = true;
                    break;
                case '1':
                    task_01.translate();
                    break;
                case '2':
                    dict1.readFromFile();
                    break;
                case '3':
                    dict1.saveToFile();
                    break;
                default:
                    System.out.println("INVALID COMMAND!");
                    break;
            }
        }
        s.close();
    }
}




























