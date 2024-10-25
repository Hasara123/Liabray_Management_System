package view;

import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import controller.MemberController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Book;
import model.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookViewAllController implements Initializable {
    @FXML
    private TableView<Book> tblViewAll;

    @FXML
    private TableColumn<?, ?> colBookid;

    @FXML
    private TableColumn<?, ?> colBooktit;

    @FXML
    private TableColumn<?, ?> colBookauth;

    @FXML
    private TableColumn<?, ?> colBookqty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblViewAll.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        tblViewAll.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Title"));
        tblViewAll.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Author"));
        tblViewAll.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        ArrayList<Book> books= BookController.viewAllBook();


        //set data to the fx table
        tblViewAll.setItems(FXCollections.observableArrayList(books));

    }


    @FXML
    private JFXTextField SearchBox;

    @FXML
    void SearchBox(ActionEvent event) {
        String filter = SearchBox.getText();

        ArrayList<Book>  books = BookController.viewAllBook();
        ArrayList<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().contains(filter) || book.getAuthor().contains(filter) || (book.getQuantity()) == Integer.parseInt(filter)) {
                filteredBooks.add(book);
            }
        }


        tblViewAll.setItems(FXCollections.observableArrayList(filteredBooks));
    }


    @FXML
    private AnchorPane BookvViewAllroot;

    @FXML
    void back(ActionEvent event) {

        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookCRUD.fxml"));

            Stage primaryStage = (Stage) BookvViewAllroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
