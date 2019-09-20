package com.steven.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Steven Rumanto
 * 1772026
 */

public class BangunRuangController {
    public TextField Panjang;
    public TextField Lebar;
    public TextField Radius;
    public TextField Tinggi;
    public String status="";
    NumberFormat formatter = new DecimalFormat("#0.00");

    public void submit(ActionEvent actionEvent) {
        int radius,tinggi,lebar,panjang;
        double luas,luasPermukaan,volume,keliling;
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        if(status=="bola"){
            radius = Integer.valueOf(Radius.getText());
            luasPermukaan=4*Math.PI*Math.pow(radius,2);
            volume=(4/3)*Math.PI*Math.pow(radius,3);
            a.setContentText("LuasPermukaan: "+formatter.format(luasPermukaan) +",Volume: "+formatter.format(volume));
            a.show();
        }else if(status=="tabung"){
            radius = Integer.valueOf(Radius.getText());
            tinggi = Integer.valueOf(Tinggi.getText());
            luasPermukaan=2*Math.PI*radius*(radius+tinggi);
            volume=Math.PI*Math.pow(radius,2)*tinggi;
            a.setContentText("LuasPermukaan: "+ formatter.format(luasPermukaan) +",Volume: "+formatter.format(volume));
            a.show();
        }else if(status=="kotak"){
            panjang = Integer.valueOf(Panjang.getText());
            lebar = Integer.valueOf(Lebar.getText());
            luas=panjang*lebar;
            keliling=2*(panjang+lebar);
            a.setContentText("Luas: "+formatter.format(luas)+",Keliling: "+formatter.format(keliling));
            a.show();
        }


    }


    public void bola(ActionEvent actionEvent) {
        status="bola";
        Panjang.setDisable(true);
        Lebar.setDisable(true);
        Radius.setDisable(false);
        Tinggi.setDisable(true);
        Panjang.setText("");
        Lebar.setText("");
        Tinggi.setText("");


    }


    public void tabung(ActionEvent actionEvent) {
        status="tabung";
        Panjang.setDisable(true);
        Lebar.setDisable(true);
        Radius.setDisable(false);
        Tinggi.setDisable(false);
        Panjang.setText("");
        Lebar.setText("");

    }

    public void kotak(ActionEvent actionEvent) {
        status="kotak";
        Panjang.setDisable(false);
        Lebar.setDisable(false);
        Radius.setDisable(true);
        Tinggi.setDisable(true);
        Radius.setText("");
        Tinggi.setText("");
    }
}
