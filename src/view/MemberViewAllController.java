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

public class MemberViewAllController implements Initializable {
    @FXML
    private TableView<Member> tblViewAll;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colNo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblViewAll.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
        tblViewAll.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblViewAll.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblViewAll.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("mobile"));

        ArrayList<Member> members = MemberController.viewAllMember();


        //set data to the fx table
        tblViewAll.setItems(FXCollections.observableArrayList(members));



    }

    @FXML
    private JFXTextField filterField;
    @FXML
    void filterField(ActionEvent event) {
        String filter = filterField.getText();

        ArrayList<Member> members = MemberController.viewAllMember();
        ArrayList<Member> filteredMembers = new ArrayList<>();

        for (Member member : members) {
            if (member.getName().contains(filter) || member.getAddress().contains(filter) || member.getMobile().contains(filter)) {
                filteredMembers.add(member);
            }
        }

        tblViewAll.setItems(FXCollections.observableArrayList(filteredMembers));
    }


    @FXML
    private AnchorPane MemberViewAllroot;
    @FXML
    void back(ActionEvent event) {

        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberCRUD.fxml"));

            Stage primaryStage = (Stage) MemberViewAllroot.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
