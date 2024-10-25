package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartFormController {

    @FXML
    private AnchorPane Startroot;

    @FXML
    void Start(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("Loginform.fxml"));

            Stage primaryStage = (Stage) Startroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
