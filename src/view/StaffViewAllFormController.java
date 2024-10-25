package view;

import controller.MemberController;
import controller.SignupController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Member;
import model.Signup;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffViewAllFormController implements Initializable {
    @FXML
    private TableView<?> tblStaffViewAll;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblStaffViewAll.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("UserName"));
        tblStaffViewAll.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("email"));

        ArrayList<Signup> signups = SignupController.staffViewAll();


        //set data to the fx table
       // tblStaffViewAll.setItems(FXCollections.observableArrayList(signups));
    }
}

