package view;

import com.jfoenix.controls.JFXTextField;
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

public class MemberUpdateController {

    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtmId;

    @FXML
    private JFXTextField txtmName;

    @FXML
    private JFXTextField txtmAddress;

    @FXML
    private JFXTextField txtmMobNo;

    @FXML
    void Search(ActionEvent event) {
        String id = txtId.getText();

        Member is = MemberController.searchMember(id);
        txtmId.setText(is.getId());
        txtmName.setText(is.getName());
        txtmAddress.setText(is.getAddress());
        txtmMobNo.setText(is.getMobile());

    }

    @FXML
    void Update(ActionEvent event) {
        String Id = txtmId.getText();
        String Name = txtmName.getText();
        String Address = txtmAddress.getText();
        String Mobile = txtmMobNo.getText();

        Member member = new Member();
        member.setId(Id);
        member.setName(Name);
        member.setAddress(Address);
        member.setMobile(Mobile);

        boolean is = MemberController.updateMember(member);

    }

    @FXML
    private AnchorPane MemberUpdateroot;

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberCRUD.fxml"));

            Stage primaryStage = (Stage) MemberUpdateroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
