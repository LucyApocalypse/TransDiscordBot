package com.artemgafarov.cryptography;

import com.artemgafarov.cryptography.Exceptions.InitException;
import com.artemgafarov.cryptography.Resources.SecretKey;

/**
 * Created by fada on 22.01.17.
 */
public class Decryption {
    private static String key;
    private static String text;
    private static Character[][] characters;
    private static Character[] symbols;
    private static Character specCharacter;

    public static void setSpecCharacter(Character specCharacter) {
        Decryption.specCharacter = specCharacter;
    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        Decryption.key = key;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Decryption.text = text;
    }

    public static void _init(){
        SecretKey.setKey(key);
        SecretKey.setTextLength(text.length());
        SecretKey._init();
        SecretKey.generateColumns();
        characters = SecretKey.getTextMatrix();
        symbols = SecretKey.getSymbol();
    }

    public static String decrypt() throws InitException {

        if(characters == null || symbols == null){
            throw new InitException("Initialization Error. Try to use _init()");
        }

        String encryptedData = "";

        int f = 0;
        for (int i = 0; i < characters.length; i++){
            for (int j = 0; j < characters[i].length; j++){
                if(f < text.length()) {
                    characters[i][j] = text.charAt(f);
                    f++;
                }else {
                    characters[i][j] = specCharacter;
                }
            }
        }

        int secretNumber = 0;
        int len = key.length();


        for (int i = 0; i < len; i++){
            for (int j = 0; j < i; j++){
                secretNumber += ((int)key.charAt(i)  + (int)key.charAt(j) + len - i + j);
                f += secretNumber;
            }
        }



        for (int i = 0; i < symbols.length; i++){
            f = 0;
            for (int j = 0; j < key.length(); j++){
                if(symbols[i] == key.toLowerCase().charAt(j)){
                    for (int a = 0; a < characters.length; a++){
                        encryptedData += (char)((int)characters[a][f] + secretNumber + f + (int)key.charAt(0) + (int)specCharacter);
                    }
                }
                f++;
            }
        }




        return new StringBuilder(encryptedData).reverse().toString();
    }
}
