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

import java.io.IOException;

public class DeleteFormController {
    @FXML
    private JFXTextField txtDeleteId;


    @FXML
    void Delete(ActionEvent event) {
        String id = txtDeleteId.getText();

        boolean is = MemberController.deleteMember(id);

    }
    @FXML
    private AnchorPane MemberDeleteroot;

    @FXML
    void Back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberCRUD.fxml"));

            Stage primaryStage = (Stage) MemberDeleteroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}



