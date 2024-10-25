package view;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;


public class DashboardFormController {


    public AnchorPane mainContext;



    @FXML
    void Staff(ActionEvent event) {

    }

    @FXML
    void bookDetail(ActionEvent event) {

    }

    @FXML
    void bookIssueDetail(ActionEvent event) {

    }

    @FXML
    void memberDetail(ActionEvent event) {

    }

    @FXML
    void returnBookDetail(ActionEvent event) {

    }

    @FXML
    void Books(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BookCRUD.fxml"));
            Parent root = loader.load();

            // Get the controller of the loaded FXML file
            BookCRUDController controller = loader.getController();
            // Set the controller's data if necessary

            // Add the root node to the main context AnchorPane
            mainContext.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Member(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberCRUD.fxml"));
            Parent root = loader.load();

            // Get the controller of the loaded FXML file
            MemberCRUDController controller = loader.getController();
            // Set the controller's data if necessary

            // Add the root node to the main context AnchorPane
            mainContext.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void IssueBook(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("IssueBookForm.fxml"));

            Stage primaryStage = (Stage) mainContext.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    void logout(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to log out and close the application?");
        alert.setContentText("Any unsaved changes will be lost.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // close the application
            Platform.exit();
        }
    }


    public void BookReturn(ActionEvent actionEvent) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("ReturnBookForm.fxml"));

            Stage primaryStage = (Stage) mainContext.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}