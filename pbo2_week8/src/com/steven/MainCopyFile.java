package com.steven;

import java.io.*;
public class MainCopyFile {

    public static void main(String[] args) {
        BufferedReader in=null;
        BufferedWriter out =null;
        try{
            in=new BufferedReader(new FileReader("res/testfile.txt"));
            out=new BufferedWriter(new FileWriter("res/testfileout.txt"));
            int c;
            while((c=in.read()) != -1){
                out.write(c);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if(in!=null){
                    in.close();
                }
                if(out!=null){
                    out.close();
                }
            } catch(IOException ee){
                System.out.println(ee.getMessage());
            }
        }
    }
}
