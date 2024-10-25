package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import controller.IssueController;
import controller.ReturnController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Book;
import model.Issue;
import model.BookReturn;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReturnBookFormController implements Initializable {

    @FXML
    private AnchorPane returnroot;

    @FXML
    private JFXComboBox cmbissueId;

    @FXML
    private JFXTextField mId;


    @FXML
    private JFXTextField returnId;

    @FXML
    private JFXTextField bId;

    @FXML
    private JFXTextField issueDate;

    @FXML
    private JFXTextField dueDate;

    @FXML
    private DatePicker returnDate;



    @FXML
    void Onissue(ActionEvent event) {
        Issue issue = ReturnController.searchIssue((String) cmbissueId.getValue());
        mId.setText(issue.getBorrowerId());
        bId.setText(issue.getBookcode());
        issueDate.setText(issue.getIssueDate());
        dueDate.setText(issue.getDueDate());

    }

    @FXML
    <ReturnBook>
    void Onreturn(ActionEvent event) {
        String memberId = mId.getText();
        String bookId = bId.getText();
        String returnDate = String.valueOf(LocalDate.now());
        String returnid = returnId.getText();


        BookReturn bookReturn=new BookReturn();
         bookReturn.setBorrowerId(memberId);
         bookReturn.setBookCode(bookId);
         bookReturn.setReturnDate(returnDate);
         bookReturn.setQuantity(1);
         bookReturn.setReturnId(returnid);
         bookReturn.setISBN(bookId);

        boolean isBookReturned = ReturnController.returnBook(bookReturn);
        System.out.println(isBookReturned);

        if (isBookReturned) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Book Return Successful");
            alert.setHeaderText(null);
            alert.setContentText("The book has been returned successfully.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Book Return Failed");
            alert.setHeaderText(null);
            alert.setContentText("Failed to return the book. Please check your input and try again.");
            alert.showAndWait();
        }
    }






    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("DashboardForm.fxml"));

            Stage primaryStage = (Stage)returnroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> issueIds = ReturnController.loadissueIds();

        //fx
        ObservableList<String> ids = FXCollections.observableArrayList();

        for (String id : issueIds) {
            ids.add(id);
        }

        cmbissueId.setItems(ids);
    }

    }

