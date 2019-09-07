package com.steven.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class GuntingKertasBatuController {


    public ImageView imageUser;
    public ImageView imageComputer;
    public Label LabelWin;
    public Label LabelDraw;
    public Label LabelLose;
    public int menang = 0;
    public int sama = 0;
    public int kalah = 0;


    Random acak = new Random();

    public void Kertas(ActionEvent actionEvent) {
        int royAcak = acak.nextInt(3);
        Image gambarComputer = new Image("/com/steven/gambar/" + String.valueOf(royAcak + 1) + ".png");
        Image gambarUser = new Image("/com/steven/gambar/1.png");
        imageUser.setImage(gambarUser);
        imageComputer.setImage(gambarComputer);
        if (royAcak + 1 == 1) {
            sama++;
            LabelDraw.setText(String.valueOf(sama));
        } else if (royAcak + 1 == 2) {
            menang++;
            LabelWin.setText(String.valueOf(menang));
        } else if (royAcak + 1 == 3) {
            kalah++;
            LabelLose.setText(String.valueOf(kalah));
        }

    }

    public void Batu(ActionEvent actionEvent) {
        int royAcak = acak.nextInt(3);
        Image gambarComputer = new Image("/com/steven/gambar/" + String.valueOf(royAcak + 1) + ".png");
        Image gambarUser = new Image("/com/steven/gambar/2.png");
        imageUser.setImage(gambarUser);
        imageComputer.setImage(gambarComputer);
        if (royAcak + 1 == 2) {
            sama++;
            LabelDraw.setText(String.valueOf(sama));
        } else if (royAcak + 1 == 3) {
            menang++;
            LabelWin.setText(String.valueOf(menang));
        } else if (royAcak + 1 == 1) {
            kalah++;
            LabelLose.setText(String.valueOf(kalah));
        }
    }

    public void Gunting(ActionEvent actionEvent) {
        int royAcak = acak.nextInt(3);
        Image gambarComputer = new Image("/com/steven/gambar/" + String.valueOf(royAcak + 1) + ".png");
        Image gambarUser = new Image("/com/steven/gambar/3.png");
        imageUser.setImage(gambarUser);
        imageComputer.setImage(gambarComputer);
        if (royAcak + 1 == 3) {
            sama++;
            LabelDraw.setText(String.valueOf(sama));
        } else if (royAcak + 1 == 1) {
            menang++;
            LabelWin.setText(String.valueOf(menang));
        } else if (royAcak + 1 == 2) {
            kalah++;
            LabelLose.setText(String.valueOf(kalah));
        }
    }

    public void Keluar(ActionEvent actionEvent) {
        Platform.exit();
    }
}
