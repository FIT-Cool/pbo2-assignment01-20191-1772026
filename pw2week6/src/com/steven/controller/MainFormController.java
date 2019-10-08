package com.steven.controller;


import com.steven.dao.DepartmentDaoImpl;
import com.steven.entity.ProgramStudi;
import com.steven.util.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

//import com.steven.entity.ProgramStudi;

//import com.steven.entity.ProgramStudi;


public class MainFormController implements Initializable {
    @FXML
    private ComboBox<ProgramStudi> combo;
    private ObservableList<ProgramStudi> departments;
    private DepartmentDaoImpl departmentDao;
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
    @FXML
    private void select(ActionEvent actionEvent) {
        JasperPrint jp= null;
        HashMap param=new HashMap();
        param.put("Prodi",combo.getValue().getId());
        try {
            jp = JasperFillManager.fillReport("report/report2.jasper", param, DBHelper.createMySQLConnection());
        } catch (JRException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        JasperViewer viewer=new JasperViewer(jp,false);
        viewer.setTitle("Department Report");
        viewer.setVisible(true);

    }

    @FXML
    private void all(ActionEvent actionEvent) {

        JasperPrint jp= null;
        try {
            jp = JasperFillManager.fillReport("report/report1.jasper", new HashMap<>(), DBHelper.createMySQLConnection());JasperViewer viewer=new JasperViewer(jp,false);
            viewer.setTitle("Department Report");
            viewer.setVisible(true);
        } catch (JRException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


//        JasperPrintManager.printReport("repo"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        combo.setItems(getDepartments());
    }
}
