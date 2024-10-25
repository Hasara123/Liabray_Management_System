package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
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
import model.Book;
import model.Member;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookSearchFormController implements Initializable {


    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtQuantity;


    @FXML
    private JFXComboBox cmbBookId;

    @FXML
    void Search(ActionEvent event) {
        Book book = BookController.searchBook((String) cmbBookId.getValue());
        txtId.setText(book.getISBN());
        txtTitle.setText(book.getTitle());
        txtAuthor.setText(book.getAuthor());
        txtQuantity.setText(String.valueOf(book.getQuantity()));


    }
    @FXML
    private AnchorPane BookSearchroot;

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookCRUD.fxml"));

            Stage primaryStage = (Stage) BookSearchroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> bookIds = BookController.loadBookIds();

        //fx
        ObservableList<String> ids = FXCollections.observableArrayList();

        for (String id : bookIds) {
            ids.add(id);
        }

        cmbBookId.setItems(ids);
    }
}
