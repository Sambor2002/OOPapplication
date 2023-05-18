package bank;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class ATMmachineApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private TextField field = new TextField();

    private Parent createContent() {
        VBox vbox = new VBox();
        vbox.setPrefSize(600, 600);

        Button btnSubmit = new Button("Submit");
        Button btnDeposit = new Button("Deposit");
        Button btnWithdraw = new Button("Withdraw");
        Button btnExit = new Button("Exit");

        TextArea areaInfo = new TextArea();

        vbox.getChildren().addAll(field, btnSubmit, btnDeposit, btnWithdraw, btnExit, areaInfo);
        return vbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
