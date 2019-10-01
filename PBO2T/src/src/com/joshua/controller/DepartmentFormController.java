package src.com.joshua.controller;

import com.steven.dao.DepartmentDaoImpl;
import com.steven.entity.ProgramStudi;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

        public ObservableList<ProgramStudi> getDepartments() {
            if(departments == null)
            {
                departments = FXCollections.observableArrayList();
                departments.addAll(getDepartmentDao().showAll());
            }
            return departments;
        }

        public DepartmentDaoImpl getDepartmentDao() {
            if(departmentDao == null)
            {
                departmentDao = new DepartmentDaoImpl();
            }
            return departmentDao;
        }

        private ObservableList<ProgramStudi> departments;

        private DepartmentDaoImpl departmentDao;


        public void saveButtonAction(ActionEvent actionEvent) {
            ProgramStudi p = new ProgramStudi();
            p.setId(5);
            p.setNama("asdasda");
            departmentDao.addData(p);
        }

        public void resetButtonAction(ActionEvent actionEvent) {
        }

        public void updateButtonAction(ActionEvent actionEvent) {
        }

        public void deleteButtonAction(ActionEvent actionEvent) {
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            tablePS.setItems(getDepartments());
            colID.setCellValueFactory( data ->   new SimpleIntegerProperty(data.getValue().getId()).asObject());
            colNama.setCellValueFactory( data -> new SimpleStringProperty(data.getValue().getNama()));
        }


    public void showMahasiswaAction(ActionEvent actionEvent) {
    }
}

