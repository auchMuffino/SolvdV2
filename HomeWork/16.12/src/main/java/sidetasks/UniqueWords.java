package sidetasks;

import java.io.*;
import java.util.*;

public class UniqueWords {
    String filePath = "";

    public UniqueWords(String filePath){
        this.filePath = filePath;
    }

    public int countOfWords() throws IOException {
        HashSet<String> words = new HashSet<>(); words.add(""); Scanner sc = new Scanner(new File(this.filePath)); while (sc.hasNextLine()) words.addAll(Arrays.stream((sc.nextLine().toLowerCase().trim().split("\\W"))).toList()); return words.size()-1;
    }
}