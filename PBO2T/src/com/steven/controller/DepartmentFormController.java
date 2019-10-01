package com.steven.controller;

import com.steven.dao.DepartmentDaoImpl;
import com.steven.entity.ProgramStudi;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentFormController implements Initializable {
    public Button saveButton;
    public Button resetButton;
    public Button updateButton;
    public Button deleteButton;
    public TextField txtNama;
    public TableColumn<ProgramStudi, Integer> colID;
    public TableColumn<ProgramStudi, String> colNama;
    public TableView<ProgramStudi> tablePS;
    public TextField txtID;
    public MenuItem showMahasiswa;
    public ProgramStudi selectedItem;
    private ObservableList<ProgramStudi> departments;
    private DepartmentDaoImpl departmentDao;
private MahasiswaFormController mahasiswaFormController;

    public ObservableList<ProgramStudi> getDepartments() {
        if (departments == null) {
            departments = FXCollections.observableArrayList();
            departments.addAll(getDepartmentDao().showAll());
        }
        return departments;
    }

    public DepartmentDaoImpl getDepartmentDao() {
        if (departmentDao == null) {
            departmentDao = new DepartmentDaoImpl();
        }
        return departmentDao;
    }


    public void saveButtonAction(ActionEvent actionEvent) {
        ProgramStudi p = new ProgramStudi();
        boolean notDuplicate=getDepartments().stream().filter(d -> d.getId() == p.getId()).count() ==0;
        if (notDuplicate){
            p.setId(Integer.valueOf(txtID.getText()));
            p.setNama(txtNama.getText());
            departmentDao.addData(p);
            departments.addAll(getDepartmentDao().showAll());
        }
        clear();
    }

    public void resetButtonAction(ActionEvent actionEvent) {
        clear();
    }

    private void clear(){
        txtID.clear();
        txtNama.clear();
        deleteButton.setDisable(true);
        updateButton.setDisable(true);
        saveButton.setDisable(false);
        tablePS.getSelectionModel().clearSelection();
        selectedItem=null;
    }

    public void updateButtonAction(ActionEvent actionEvent) {
        if (!txtNama.getText().trim().isEmpty()){
            selectedItem.setNama(txtNama.getText().trim());
            getDepartmentDao().updateData(selectedItem);
            tablePS.refresh();
            clear();
        }
    }

    public void deleteButtonAction(ActionEvent actionEvent) {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Apakah yakin mau menghapus data?");
        a.setContentText("Konfismasi Hapus");
        a.showAndWait();
        if (a.getResult() == ButtonType.OK){
            getDepartmentDao().deleteData(selectedItem);
            getDepartments().setAll(getDepartmentDao().showAll());
            tablePS.refresh();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clear();
        tablePS.setItems(getDepartments());
        colID.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
    }


    public void showMahasiswaAction(ActionEvent actionEvent) {
    }

    public void tableclick(MouseEvent mouseEvent) {
        selectedItem = tablePS.getSelectionModel().getSelectedItem();
        txtID.setText(String.valueOf(selectedItem.getId()));
        txtNama.setText(selectedItem.getNama());
        deleteButton.setDisable(false);
        saveButton.setDisable(true);
        updateButton.setDisable(false);
        txtID.setDisable(true);
    }
}

