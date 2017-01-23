package com.artemgafarov.gui;

import com.artemgafarov.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by fada on 23.01.17.
 */

public class MainWindow extends Application{

    @FXML
    private TextField specSymbol;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CryptPHY");

        ClassLoader classLoader = Main.class.getClassLoader();

        Parent parent = FXMLLoader.load(classLoader.getResource("xmls/MainWindow.fxml"));
        stage.setScene(new Scene(parent));
        stage.setResizable(true);
        stage.getIcons().add(new Image(classLoader.getResourceAsStream("images/icon.png")));
        stage.show();
    }
}
