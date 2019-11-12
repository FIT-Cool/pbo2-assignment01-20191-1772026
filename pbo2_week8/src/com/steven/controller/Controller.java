package com.steven.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {
    public TextArea textArea;
    public AnchorPane root;

    public void save(ActionEvent actionEvent) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Save File");
        File file=fileChooser.showSaveDialog(root.getScene().getWindow());
        if (file!=null){
            Path path= file.toPath();
            if (!Files.exists(path)){
                try {
                    Files.createFile(path);
                    BufferedWriter writer=Files.newBufferedWriter(path);
                    writer.write(textArea.getText());
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void open(ActionEvent actionEvent) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Open File");
        File file=fileChooser.showOpenDialog(root.getScene().getWindow());
        Path path= file.toPath();
        if (Files.exists(path) && Files.isReadable(path)){
            try {
                BufferedReader reader=Files.newBufferedReader(path);
                String line;
                while ((line=reader.readLine()) != null){
                    textArea.appendText(line);
                    textArea.appendText(System.lineSeparator());
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
