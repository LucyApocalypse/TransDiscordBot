package com.artemgafarov;

import com.artemgafarov.gui.MainWindow;
/**
 * Created by fada on 22.01.17.
 */
public class Main {
    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(MainWindow.class);
            }
        }.start();


    }
}
