package com.steven.controller;

import com.steven.dao.DepartmentDaoImpl;
import com.steven.dao.MahasiswaDaoImpl;
import com.steven.entity.Mahasiswa;
import com.steven.entity.ProgramStudi;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class MahasiswaFormController implements Initializable {
    public MenuItem showMahasiswa;
    public TextField txtIDMahasiswa;
    public TextField txtNamaDepan;
    public TextField txtNamaBelakang;
    public TextField txtTempatLahir;
    public TextField txtAlamat;
    public TextField txtEmail;
    public Button saveButton;
    public Button resetButton;
    public Button updateButton;
    public Button deleteButton;
    public TableView<Mahasiswa> tablePS;
    public TableColumn<Mahasiswa, String> colID;
    public TableColumn<Mahasiswa, String> colNamaDepan;
    public TableColumn<Mahasiswa, String> colNamaBelakang;
    public TableColumn<Mahasiswa, String> colTempatLahir;
    public TableColumn<Mahasiswa, String> colTanggalLahir;
    public TableColumn<Mahasiswa, String> colAlamat;
    public TableColumn<Mahasiswa, String> colEmail;
    public TableColumn<Mahasiswa, String> colProdi;
    public DatePicker txtTanggalLahir;
    public ComboBox<ProgramStudi> comboProgramStudi;
    private ObservableList<Mahasiswa> mahasiswas;
    private MahasiswaDaoImpl mahasiswaDao;
    private ObservableList<ProgramStudi> departments;
    private DepartmentDaoImpl departmentDao;
    private Mahasiswa selectedItem;

    public ObservableList<Mahasiswa> getMahasiswa() {
        if (mahasiswas == null) {
            mahasiswas = FXCollections.observableArrayList();
            mahasiswas.addAll(getMahasiswaDao().showAll());
        }
        return mahasiswas;
    }

    public MahasiswaDaoImpl getMahasiswaDao() {
        if (mahasiswaDao == null) {
            mahasiswaDao = new MahasiswaDaoImpl();
        }
        return mahasiswaDao;
    }

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


    public void showMahasiswaAction(ActionEvent actionEvent) {

    }

    public void saveAction(ActionEvent actionEvent) {
        Mahasiswa m = new Mahasiswa();
        boolean notDuplicate = getMahasiswa().stream().filter(d -> d.getId() == m.getId()).count() == 0;
        if (notDuplicate) {
            m.setId(txtIDMahasiswa.getText().trim());
            m.setNamaDepan(txtNamaDepan.getText());
            m.setNamaBelakang(txtNamaBelakang.getText());
            m.setAlamat(txtAlamat.getText());
            m.setEmail(txtEmail.getText());
            m.setTempatLahir(txtTempatLahir.getText());
            ProgramStudi p=new ProgramStudi();
            p.setId(comboProgramStudi.getValue().getId());
            p.setNama(comboProgramStudi.getValue().getNama());
            m.setProgramStudiByProgramStudiId(p);
            Date tanggalLahir = java.sql.Date.valueOf(txtTanggalLahir.getValue());
            m.setTanggalLahir((java.sql.Date) tanggalLahir);
            System.out.println("asdkfjhasf");
            mahasiswaDao.addData(m);
            mahasiswas.clear();
            mahasiswas.addAll(getMahasiswaDao().showAll());
        }
//        clear();
    }

    public void resetAction(ActionEvent actionEvent) {
    }

    public void updateAction(ActionEvent actionEvent) {
    }

    public void deleteAction(ActionEvent actionEvent) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablePS.setItems(getMahasiswa());
        comboProgramStudi.setItems(getDepartments());
        colID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        colNamaDepan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNamaDepan()));
        colNamaBelakang.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNamaBelakang()));
        colTempatLahir.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTempatLahir()));

        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        colTanggalLahir.setCellValueFactory(data -> {
            return new SimpleStringProperty(dateFormat.format(data.getValue().getTanggalLahir()));
        });
        colAlamat.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlamat()));
        colEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));

        colProdi.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProgramStudiByProgramStudiId().getNama()));
    }


    public void tableClicked(MouseEvent mouseEvent) {
        selectedItem = tablePS.getSelectionModel().getSelectedItem();
        comboProgramStudi.setValue(selectedItem.getProgramStudiByProgramStudiId());
        txtTanggalLahir.setValue(convert(selectedItem.getTanggalLahir()));

    }

    public LocalDate convert(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
