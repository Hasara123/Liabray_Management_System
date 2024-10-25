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
import model.Book;
import model.Member;

import java.io.IOException;

import static com.jfoenix.svg.SVGGlyphLoader.clear;

public class BookAddFormController {
    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    void Save(ActionEvent event) {
        String ISBN = txtId.getText();
        String Title = txtTitle.getText();
        String Author = txtAuthor.getText();
        String Quantity = txtQuantity.getText();

        Book book = new Book();
        book.setISBN(ISBN);
        book.setTitle(Title);
        book.setAuthor(Author);
        book.setQuantity(Integer.parseInt(Quantity));

        boolean isAdded = BookController.addBook(book);
        if (isAdded) {
            clearForm();
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtQuantity.setText("");
    }

    @FXML
    private AnchorPane BookAddroot;

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookCRUD.fxml"));

            Stage primaryStage = (Stage) BookAddroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
