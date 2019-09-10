package com.steven.controller;

import com.steven.entity.Fakultas;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private TableView<Fakultas> tableDepartment;
    @FXML
    private TextField txtNama;
    @FXML
    private TableColumn<Fakultas,String> col01;
    private ObservableList<Fakultas> fakultas;
    @FXML
    private TableColumn<Fakultas,String> col02;
    @FXML
    private TextField txtKode;

    @FXML
    private void tambahAction(ActionEvent actionEvent) {
        Fakultas f=new Fakultas();
        f.setNama(txtNama.getText().trim());
        f.setKode(txtKode.getText().trim());
        fakultas.add(f);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fakultas = FXCollections.observableArrayList();
        tableDepartment.setItems(fakultas);
        col01.setCellValueFactory((data) ->{
            Fakultas f= data.getValue();
            return new SimpleStringProperty(f.getNama());
        });
        col02.setCellValueFactory((data) ->{
            Fakultas f= data.getValue();
            return new SimpleStringProperty(f.getKode());
        });
    }
}
