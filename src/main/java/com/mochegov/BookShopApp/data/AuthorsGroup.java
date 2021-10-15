package com.mochegov.BookShopApp.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorsGroup {
    private static Map<String, String> lettersMap;
    private static void createLettersMap(){
        lettersMap.put("А", "a");
        lettersMap.put("Б", "b");
        lettersMap.put("В", "v");
        lettersMap.put("Г", "g");
        lettersMap.put("Д", "d");
        lettersMap.put("Е", "e");
        lettersMap.put("Ё", "e");
        lettersMap.put("Ж", "g");
        lettersMap.put("З", "z");
        lettersMap.put("И", "i");
        lettersMap.put("Й", "ik");
        lettersMap.put("К", "k");
        lettersMap.put("Л", "l");
        lettersMap.put("М", "m");
        lettersMap.put("Н", "n");
        lettersMap.put("О", "o");
        lettersMap.put("П", "p");
        lettersMap.put("Р", "r");
        lettersMap.put("С", "s");
        lettersMap.put("Т", "t");
        lettersMap.put("У", "u");
        lettersMap.put("Ф", "f");
        lettersMap.put("Х", "h");
        lettersMap.put("Ц", "c");
        lettersMap.put("Ч", "ch");
        lettersMap.put("Ш", "sh");
        lettersMap.put("Щ", "shh");
        lettersMap.put("Э", "ye");
        lettersMap.put("Ю", "yu");
        lettersMap.put("Я", "ya");
    };

    {
        lettersMap = new HashMap<>();
        createLettersMap();
    };

    private String letter;
    private String href;
    private List<String> authors;

    public AuthorsGroup(String letter, List<String> authors) {
        this.letter = letter;
        this.href = (String) lettersMap.get(letter);
        this.authors = new ArrayList<>(authors);
    }

    public String getLetter() {
        return letter;
    }

    public String getHref() {
        return href;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
