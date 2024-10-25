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

import java.io.IOException;

public class BookDeleteFormController {
    @FXML
    private JFXTextField txtId;

    @FXML
    void Delete(ActionEvent event) {
        String ISBN = txtId.getText();

        boolean is = BookController.deleteBook(ISBN);

    }


    @FXML
    private AnchorPane BookDeleteroot;

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookCRUD.fxml"));

            Stage primaryStage = (Stage) BookDeleteroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
