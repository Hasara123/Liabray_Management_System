package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.SignupController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Signup;

import java.io.IOException;

public class StaffSignupController {
    @FXML
    private AnchorPane root;

    @FXML
    private TilePane tilepane;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtSigemail;

    @FXML
    private JFXPasswordField txtSigpw;

    @FXML
    private JFXPasswordField txtSigpw1;

    @FXML
    void Cancel(ActionEvent event) throws IOException {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close(); // Close the current stage (i.e. the signup page)

            Parent root = FXMLLoader.load(getClass().getResource("Loginform.fxml"));
            Scene scene = new Scene(root);

            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.show();
        }


    @FXML
    void Signup(ActionEvent event) {
        String Name = txtUserName.getText();
        String password = txtSigpw.getText();
        String email = txtSigemail.getText();

        Signup signup = new Signup();
        signup.setUserName(Name);
        signup.setPassword(password);
        signup.setEmail(email);

        boolean is = SignupController.add(signup);


        if (is) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sign-up Successful");
            alert.setHeaderText("You have successfully signed up!");
            alert.setContentText("Welcome to our application, " + Name + "!");

            alert.showAndWait();
        }
    }
}
