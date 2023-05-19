package bank;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        VBox vbox = new VBox();
        vbox.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();

        Button btnSubmit = new Button("Submit");
        btnSubmit.setPrefHeight(93.0);
        btnSubmit.setPrefWidth(600.0);
        btnSubmit.setFont(Font.font("Lucida Sans Unicode",21));
        btnSubmit.setOnAction(e ->{
            int id =Integer.parseInt(field.getText());
            ATM.login(id);

            areaInfo.setText(ATM.toString());
        });

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setPrefHeight(93.0);
        btnDeposit.setPrefWidth(600.0);
        btnDeposit.setBackground(Background.fill(Color.GREEN));
        btnDeposit.setFont(Font.font("Lucida Sans Unicode",21));
        btnDeposit.setOnAction(e ->{
            int amount = Integer.parseInt(field.getText());
            ATM.deposit(amount);

            areaInfo.setText(ATM.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setPrefHeight(93.0);
        btnWithdraw.setPrefWidth(600.0);
        btnWithdraw.setBackground(Background.fill(Color.RED));
        btnWithdraw.setFont(Font.font("Lucida Sans Unicode",21));
        btnWithdraw.setOnAction(e ->{
            int amount =Integer.parseInt(field.getText());
            ATM.withdraw(amount);

            areaInfo.setText(ATM.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setPrefHeight(93.0);
        btnExit.setPrefWidth(600.0);
        btnExit.setFont(Font.font("Lucida Sans Unicode",21));
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
