package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class MemberCRUDController {


    @FXML
    private AnchorPane MemberCRUDroot;

    @FXML
    void Add(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberAdd.fxml"));

            Stage primaryStage = (Stage) MemberCRUDroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Delete(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("DeleteForm.fxml"));

            Stage primaryStage = (Stage) MemberCRUDroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void Search(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberSearch.fxml"));

            Stage primaryStage = (Stage) MemberCRUDroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void Update(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberUpdate.fxml"));

            Stage primaryStage = (Stage) MemberCRUDroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("DashboardForm.fxml"));

            Stage primaryStage = (Stage) MemberCRUDroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void ViewAll(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberViewAll.fxml"));

            Stage primaryStage = (Stage) MemberCRUDroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
