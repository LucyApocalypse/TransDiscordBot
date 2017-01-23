package com.artemgafarov.cryptography.Resources;

import java.util.*;

/**
 * Created by fada on 22.01.17.
 */
public class SecretKey {
    private static String key;
    private static long keyLength;
    private static Character[] symbol;
    private static Character[][] textMatrix;
    private static int textLength;


    public static void setTextLength(int textLength) {
        SecretKey.textLength = textLength;
    }

    public static void setKey(String key) {
        SecretKey.key = key;
    }

    public static String getKey() {
        return key;
    }

    public static Character[][] getTextMatrix() {
        return textMatrix;
    }

    public static Character[] getSymbol() {
        return symbol;
    }

    public static void _init(){
        keyLength = key.length();
        symbol = new Character[key.length()];

        int u;
        if(textLength % key.length() == 0) u = textLength / key.length();
        else u = textLength / key.length() + 1;

        textMatrix = new Character[u][key.length()];
    }

    public static void generateColumns(){



        for (int i = 0; i < symbol.length; i++){
          symbol[i] = key.charAt(i);
        }

        Arrays.sort(symbol);

        Set<Character>symbols = new TreeSet<Character>();
        List<Character> s = new LinkedList<Character>();


        for (int i = 0; i < symbol.length; i++){
            s.add(symbol[i]);
        }

        symbols = new LinkedHashSet<Character>(s);
        s = new LinkedList<Character>(symbols);

        symbol = new Character[s.size()];
        for (int i = 0; i < s.size(); i++){
            symbol[i] = s.get(i);
        }
    }
}
