package com.artemgafarov.gui.controllers;

import com.artemgafarov.cryptography.Decryption;
import com.artemgafarov.cryptography.Encryption;
import com.artemgafarov.cryptography.Exceptions.InitException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;


public class MainWindowController {

    @FXML
    private TextArea text;
    @FXML
    private TextArea key;
    @FXML
    private TextField specSymbol;

    private boolean isChecked(){

        if(text.getText().length() == 0 || key.getText().length() == 0 || specSymbol.getText().length() == 0){
            return false;
        }
        return true;
    }

    public void decrypt(ActionEvent actionEvent) {
        if(!isChecked()){
            JOptionPane.showMessageDialog(null, "Some fields are empty\n" +
                    "Fill in all the fields", "Error", 2);
            return;
        }

        if(text.getText().contains(String.valueOf(specSymbol.getText().charAt(0)))){
            JOptionPane.showMessageDialog(null, "Your text contains\nspecial symbol!", "Error", 2);
            return;
        }

        if(key.getText().contains(" ")){
            StringBuilder stringBuilder = new StringBuilder("");
            for(int i = 0; i < key.getText().length(); i++){
                if(key.getText().charAt(i) != ' '){
                    stringBuilder.append(key.getText().charAt(i));
                }
            }
            key.setText(stringBuilder.toString());
        }

        key.setText(key.getText().toLowerCase());

        Decryption.setEncryptedText(text.getText());
        Decryption.setSpecCharacter(specSymbol.getText().charAt(0));
        Decryption.setKey(key.getText());
        Decryption._init();
        try {
            text.setText(Decryption.decrypt());
        } catch (InitException e) {
            JOptionPane.showMessageDialog(null, "Some Error checked.\nTry to repeat operation", "Error", 2);
        }
    }

    public void encrypt(ActionEvent actionEvent) {
        if(!isChecked()){
            JOptionPane.showMessageDialog(null, "Some fields are empty\n" +
                    "Fill in all the fields", "Error", 2);
            return;
        }


        if(text.getText().contains(String.valueOf(specSymbol.getText().charAt(0)))){
            JOptionPane.showMessageDialog(null, "Your text contains\nspecial symbol!", "Error", 2);
            return;
        }

        if(key.getText().contains(" ")){
            StringBuilder stringBuilder = new StringBuilder("");
            for(int i = 0; i < key.getText().length(); i++){
                if(key.getText().charAt(i) != ' '){
                    stringBuilder.append(key.getText().charAt(i));
                }
            }
            key.setText(stringBuilder.toString());
        }
        key.setText(key.getText().toLowerCase());



        Encryption.setText(text.getText());
        Encryption.setSpecCharacter(specSymbol.getText().charAt(0));

        Encryption.setKey(key.getText());
        Encryption._init();
        try {
            text.setText(Encryption.encrypt());
        } catch (InitException e) {
            JOptionPane.showMessageDialog(null, "Some Error checked.\nTry to repeat operation", "Error", 2);
        }
    }
}
