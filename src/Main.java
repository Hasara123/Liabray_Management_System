import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.load(this.getClass().getResource("./view/StartForm.fxml"));
        Scene loginScene = new Scene(parent);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Member's Add Form");
        primaryStage.setTitle("Member's Delete Form");
        primaryStage.setTitle("Member's Search Form");
        primaryStage.setTitle("Member's Update Form");
          primaryStage.setTitle("Member's Main Form");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}