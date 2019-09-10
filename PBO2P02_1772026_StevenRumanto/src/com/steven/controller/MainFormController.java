package com.steven.controller;

import com.steven.entity.Category;
import com.steven.entity.Item;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    List<String> myCategory=new ArrayList<>();
    @FXML
    private ObservableList<Item> item;
    @FXML
    private TableView<Item> tableItem;
    @FXML
    private TextField txtNama;
    @FXML
    private TableColumn<Item,String> col01;
    @FXML
    private TableColumn<Item,String> col02;
    @FXML
    private TableColumn<Item,String> col03;
    @FXML
    private TextField txtPrice;
    @FXML
    private MenuItem keluar;
    @FXML
    private MenuItem tentang;
    @FXML
    private Button update;
    @FXML
    private TextField txtCategoryName;
    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private void tambahAction(ActionEvent actionEvent) {
            try {
                Item i=new Item();
                Category c=new Category();
                c.setName(choiceBox.getValue().toString());
                i.setNama(txtNama.getText().trim());
                i.setPrice(txtPrice.getText().trim());
                i.setCategory(c);
                item.add(i);
            }
            catch(Exception e) {
            }



    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        item = FXCollections.observableArrayList();
        tableItem.setItems(item);
        col01.setCellValueFactory((data) ->{
            Item f= data.getValue();
            return new SimpleStringProperty(f.getNama());
        });
        col02.setCellValueFactory((data) ->{
            Item f= data.getValue();
            return new SimpleStringProperty(f.getPrice());
        });
        col03.setCellValueFactory((data) ->{
            Item f= data.getValue();
            return new SimpleStringProperty(f.getCategory().getName());
        });
    }



    @FXML
    private void keluar(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    private void tentang(ActionEvent actionEvent) {
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Steven Rumanto \n1772026");
        a.show();
    }

    @FXML
    private void reset(ActionEvent actionEvent) {
        txtCategoryName.setText("");
        txtNama.setText("");
        txtPrice.setText("");
    }

    @FXML
    private void update(ActionEvent actionEvent) {
    }

    @FXML
    private void simpanKategori(ActionEvent actionEvent) {
        myCategory.add(txtCategoryName.getText().trim());
        choiceBox.setItems(FXCollections.observableArrayList(myCategory));

    }

    @FXML
    private void pilihTabel(MouseEvent mouseEvent) {
        if(!item.isEmpty()){
            update.setDisable(false);
            Item i=tableItem.getSelectionModel().getSelectedItem();
            choiceBox.setValue(i.getCategory().getName());
            txtNama.setText(i.getNama());
            txtPrice.setText(i.getPrice());
        }

    }
}
