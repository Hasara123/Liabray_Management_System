package view;

import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import controller.MemberController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Member;

import java.io.IOException;

public class MemberAddController {
    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    void Save(ActionEvent event) {
        String Id=txtId.getText();
        String Name=txtName.getText();
        String Address=txtAddress.getText();
        String Mobile=txtMobile.getText();

        Member member=new Member();
        member.setId(Id);
        member.setName(Name);
        member.setAddress(Address);
        member.setMobile(Mobile);


        boolean is = MemberController.addMember(member);
        if (is) {
            clearForm();
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtMobile.setText("");
    }

    @FXML
    private AnchorPane MemberAddroot;
    @FXML
    void Back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberCRUD.fxml"));

            Stage primaryStage = (Stage) MemberAddroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}


