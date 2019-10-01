package src.com.joshua.controller;

import com.steven.dao.MahasiswaDaoImpl;
import com.steven.entity.Mahasiswa;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
    public TableColumn<Mahasiswa, Integer> colID;
    public TableColumn<Mahasiswa, String> colNamaDepan;
    public TableColumn<Mahasiswa, String> colNamaBelakang;
    public TableColumn<Mahasiswa, String> colTempatLahir;
    public TableColumn<Mahasiswa, String> colTanggalLahir;
    public TableColumn<Mahasiswa, String> colAlamat;
    public TableColumn<Mahasiswa, String> colEmail;
    public TableColumn<Mahasiswa, String> colProdi;
    public DatePicker txtTanggalLahir;

    public ObservableList<Mahasiswa> getStudents() {
        if(students == null)
        {
            students = FXCollections.observableArrayList();
            students.addAll(getMahasiswaDao().showAll());
        }
        return students;
    }

    public void setStudents(ObservableList<Mahasiswa> students) {
        this.students = students;
    }

    public MahasiswaDaoImpl getMahasiswaDao() {
        if(mahasiswaDao == null)
        {
            mahasiswaDao = new MahasiswaDaoImpl();
        }
        return mahasiswaDao;
    }

    public void setMahasiswaDao(MahasiswaDaoImpl mahasiswaDao) {
        this.mahasiswaDao = mahasiswaDao;
    }

    private ObservableList<Mahasiswa> students;
    private MahasiswaDaoImpl mahasiswaDao;

    public void showMahasiswaAction(ActionEvent actionEvent) {
    }

    public void saveAction(ActionEvent actionEvent) {
    }

    public void resetAction(ActionEvent actionEvent) {
    }

    public void updateAction(ActionEvent actionEvent) {
    }

    public void deleteAction(ActionEvent actionEvent) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablePS.setItems(getStudents());
        colID.setCellValueFactory( data ->   new SimpleIntegerProperty(data.getValue().getId()).asObject());
        colNamaDepan.setCellValueFactory( data -> new SimpleStringProperty(data.getValue().getNamaDepan()));
        colNamaBelakang.setCellValueFactory( data -> new SimpleStringProperty(data.getValue().getNamaBelakang()));
        colTempatLahir.setCellValueFactory( data -> new SimpleStringProperty(data.getValue().getTempatLahir()));
        colTanggalLahir.setCellValueFactory( data -> new SimpleStringProperty(String.valueOf(data.getValue().getTanggalLahir())));
        colAlamat.setCellValueFactory( data -> new SimpleStringProperty(data.getValue().getAlamat()));
        colEmail.setCellValueFactory( data -> new SimpleStringProperty(data.getValue().getEmail()));
        colProdi.setCellValueFactory( data -> new SimpleStringProperty(data.getValue().getProgramStudi()));
    }
}
