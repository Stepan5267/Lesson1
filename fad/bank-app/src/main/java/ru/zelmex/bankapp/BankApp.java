package ru.zelmex.bankapp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BankApp extends Application {
    public static Stage primaryStage;
    public static Scene users;
    public static Scene exerciseGroups;
    public static Scene records;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage=stage;
        users=createScene("ru.zelmex.bank-app.user-view.fxml");
        exerciseGroups = createScene("ru.zelmex.bank-app.exercise-group-view.fxml");
        records = createScene("ru.zelmex.bank-app.records-view.fxml");

        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(675);

        primaryStage.setTitle("Bank manager");
        users.getStylesheets().add("base-styles.css");
        exerciseGroups.getStylesheets().add("base-styles.css");
        records.getStylesheets().add("base-styles.css");
        primaryStage.setScene(records);
        primaryStage.show();
    }
    private Scene createScene(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BankApp.class.getResource(name));
        return new Scene(fxmlLoader.load());
    }

    public static void main(String[] args) {launch();}
}