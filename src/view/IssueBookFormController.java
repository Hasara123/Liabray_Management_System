package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import controller.IssueController;
import controller.MemberController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Book;
import model.Issue;
import model.Member;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class IssueBookFormController implements Initializable {

    @FXML
    private AnchorPane issueBookroot;

    @FXML
    private JFXComboBox cmbBookID;

    @FXML
    private JFXComboBox cmbMemberID;

    @FXML
    private JFXTextField txtBookTitle;

    @FXML
    private JFXTextField txtBookAuthor;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtMName;

    @FXML
    private JFXTextField txtMaddress;

    @FXML
    private JFXTextField txtMNo;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXTextField txtIssueId;

    @FXML
    private DatePicker IssueDate;

    @FXML
    private DatePicker DueDate;


    @FXML
    void Cancel(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("DashboardForm.fxml"));

            Stage primaryStage = (Stage) issueBookroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void Issue(ActionEvent event) {
        String IssueId = txtIssueId.getText();
        String issueDate = String.valueOf(LocalDate.now());
        String dueDate = String.valueOf(LocalDate.now());
        String QuantityString = txtQuantity.getText();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(QuantityString); //"13", 13 ----> hasara ---> Numberformat exception
        } catch (NumberFormatException ex) {
            System.out.println("Please Enter Only Numbers !");
        }

        Issue issue = new Issue();
        issue.setIssueId(IssueId);
        issue.setBookcode((String) cmbBookID.getValue());
        issue.setBorrowerId((String) cmbMemberID.getValue());
        issue.setIssueDate(issueDate);
        issue.setDueDate(dueDate);
        issue.setQuantity(quantity);


        boolean isBookIssue = IssueController.issueBook(issue);
        System.out.println(isBookIssue);
    }


    @FXML
    void cmbBook(ActionEvent event) {
        Book book = BookController.searchBook((String) cmbBookID.getValue());
        txtBookTitle.setText(book.getTitle());
        txtBookAuthor.setText(book.getAuthor());
        txtQuantity.setText(String.valueOf((book.getQuantity())));
        txtBookId.setText(book.getISBN());

    }

    @FXML
    void cmbMember(ActionEvent event) {
        Member member = MemberController.searchMember((String) cmbMemberID.getValue());
        txtMName.setText(member.getName());
        txtMaddress.setText(member.getAddress());
        txtMNo.setText(member.getMobile());
        txtMemberId.setText(member.getId());



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadMemberIds();
        loadBookIds();
    }

    public void loadMemberIds() {
        ArrayList<String> memberIds = MemberController.loadMemberIds();

        //fx
        ObservableList<String> IDS = FXCollections.observableArrayList();

        for (String ids : memberIds) {
            IDS.add(ids);
        }

        cmbMemberID.setItems(IDS);
    }

    public void loadBookIds() {
        ArrayList<String> bookIds = BookController.loadBookIds();

        //fx
        ObservableList<String> ids = FXCollections.observableArrayList();

        for (String id : bookIds) {
            ids.add(id);
        }

        cmbBookID.setItems(ids);
    }
}

