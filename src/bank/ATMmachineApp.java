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
    private ATM ATM = new ATM(new Bank());

    private Parent createContent() {
        VBox vbox = new VBox(21);
        vbox.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();

        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(e ->{
            int id =Integer.parseInt(field.getText());
            ATM.login(id);

            areaInfo.setText(ATM.toString());
        });

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e ->{
            int amount = Integer.parseInt(field.getText());
            ATM.deposit(amount);

            areaInfo.setText(ATM.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e ->{
            int amount =Integer.parseInt(field.getText());
            ATM.withdraw(amount);

            areaInfo.setText(ATM.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e ->{
            ATM.exit();

            areaInfo.setText(ATM.toString());
        });


        vbox.getChildren().addAll(field, btnSubmit, btnDeposit, btnWithdraw, btnExit, areaInfo);
        return vbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
