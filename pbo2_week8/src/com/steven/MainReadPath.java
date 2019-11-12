package com.steven;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainReadPath {

    public static void main(String[] args) {
        Path path= Paths.get("res/testfile.txt");
        if(Files.exists(path) && Files.isReadable(path)){
            try{
                try(BufferedReader reader=Files.newBufferedReader(path)){
                    String s;
                    while((s=reader.readLine())!=null){
                        System.out.println(s);
                    }
                }
            }catch (IOException e) {
                Logger.getLogger(MainReadPath.class.getName()).
                log(Level.SEVERE,null,e);
            }
        }
    }
}
