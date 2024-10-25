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

public class BookUpdateFormController {
    @FXML
    private JFXTextField txtBId;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    void Search(ActionEvent event) {
        String id = txtBId.getText();

        Book is = BookController.searchBook(id);
        txtId.setText(is.getISBN());
        txtTitle.setText(is.getTitle());
        txtAuthor.setText(is.getAuthor());
        int Quantity = is.getQuantity();
        txtQuantity.setText(String.valueOf(Quantity));



    }

    public void clear(){
        txtId.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtQuantity.setText("");

    }

    @FXML
    void Update(ActionEvent event) {
        String Id = txtBId.getText();
        String Title = txtTitle.getText();
        String Author = txtAuthor.getText();
        String Quantity = txtQuantity.getText();

        Book book = new Book();
        book.setISBN(Id);
        book.setTitle(Title);
        book.setAuthor(Author);
        book.setQuantity(Integer.parseInt(Quantity));

        boolean is = BookController.updateBook(book);

    }

    @FXML
    private AnchorPane BookUpdateroot;

    @FXML
    void back(ActionEvent event) {

        try{
            Parent view = FXMLLoader.load(this.getClass().getResource("BookCRUD.fxml"));

            Stage primaryStage = (Stage) BookUpdateroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
