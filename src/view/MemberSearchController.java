package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.MemberController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static controller.MemberController.loadMemberIds;

public class MemberSearchController implements Initializable {

    @FXML
    private JFXTextField txtmId;

    @FXML
    private JFXTextField txtmName;

    @FXML
    private JFXTextField txtmAddress;

    @FXML
    private JFXTextField txtmMobiNo;


    @FXML
    private JFXComboBox cmbSearchMember;

    @FXML
    void Search(ActionEvent event) {
        Member member = MemberController.searchMember((String) cmbSearchMember.getValue());
        txtmId.setText(member.getId());
        txtmName.setText(member.getName());
        txtmAddress.setText(member.getAddress());
        txtmMobiNo.setText(member.getMobile());

    }

    @FXML
    private AnchorPane MemberSearchroot;

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberCRUD.fxml"));

            Stage primaryStage = (Stage) MemberSearchroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> memberIds = MemberController.loadMemberIds();

        //fx
        ObservableList<String> ids = FXCollections.observableArrayList();

        for (String id : memberIds) {
            ids.add(id);
        }

        cmbSearchMember.setItems(ids);
    }
}





