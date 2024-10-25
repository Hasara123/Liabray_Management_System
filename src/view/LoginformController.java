package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.DatabaseConnection;;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginformController implements Initializable {


    @FXML
    private AnchorPane Loginroot;

    @FXML
    private JFXTextField txtUserId;


    @FXML
    private JFXPasswordField txtUserPw;

    @FXML
    void SignUp(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("Signup.fxml"));

            Stage primaryStage = (Stage) Loginroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void Cancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartForm.fxml"));
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    Stage dialogStage = new Stage();
    Scene scene;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public LoginformController() {
        connection = DatabaseConnection.connectdb();
    }



    @FXML
    void Login(ActionEvent event) throws SQLException {
        String UserName = txtUserId.getText();
        String password = txtUserPw.getText();


        String sql = "SELECT * FROM Staff WHERE UserName = ? and password = ?";


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                infoBox("Please enter correct UserName and Password", null, "Failed");
            }else{
                infoBox("Login Successfull",null,"Success" );
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("DashboardForm.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}