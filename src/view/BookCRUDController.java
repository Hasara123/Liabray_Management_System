package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Book;

import java.io.IOException;

public class BookCRUDController {

    @FXML
    private AnchorPane BookCRUDroot;


    @FXML
    void BookAdd(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookAddForm.fxml"));

            Stage primaryStage = (Stage) BookCRUDroot.getScene().getWindow();
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
            Parent view = FXMLLoader.load(this.getClass().getResource("BookDeleteForm.fxml"));

            Stage primaryStage = (Stage) BookCRUDroot.getScene().getWindow();
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
            Parent view = FXMLLoader.load(this.getClass().getResource("BookSearchForm.fxml"));

            Stage primaryStage = (Stage) BookCRUDroot.getScene().getWindow();
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
            Parent view = FXMLLoader.load(this.getClass().getResource("BookUpdateForm.fxml"));

            Stage primaryStage = (Stage) BookCRUDroot.getScene().getWindow();
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
            Parent view = FXMLLoader.load(this.getClass().getResource("DashBoardForm.fxml"));

            Stage primaryStage = (Stage) BookCRUDroot.getScene().getWindow();
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
            Parent view = FXMLLoader.load(this.getClass().getResource("BookViewAll.fxml"));

            Stage primaryStage = (Stage) BookCRUDroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
