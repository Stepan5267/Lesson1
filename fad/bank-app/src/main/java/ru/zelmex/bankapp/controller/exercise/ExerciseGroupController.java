package ru.zelmex.bankapp.controller.exercise;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.zelmex.bankapp.BankApp;
import ru.zelmex.bankapp.model.ExerciseGroup;

public class ExerciseGroupController {

    @FXML
    private TableView<ExerciseGroup> exerciseGroupsTable;

    @FXML
    private TableColumn<ExerciseGroup, String> titleColumn;

    @FXML
    private TableColumn<ExerciseGroup, String> typeOfLoadColumn;

    @FXML
    private TableColumn<ExerciseGroup, String> normsColumn;

    @FXML
    private void initialize() {
        // Настройка колонок - используем геттеры из вашего класса
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeOfLoadColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfLoad"));
        normsColumn.setCellValueFactory(new PropertyValueFactory<>("norms"));
    }

    @FXML
    private void switchToUsers() {
        BankApp.primaryStage.setScene(BankApp.users);
    }

    @FXML
    private void switchToRecords() {
        BankApp.primaryStage.setScene(BankApp.records);
    }

    @FXML
    private void exit() {
        System.exit(0);
    }

    @FXML
    private void btnAdd() {
        System.out.println("Добавить упражнение");
    }

    @FXML
    private void btnEdit() {
        System.out.println("Редактировать упражнение");
    }

    @FXML
    private void btnDelete() {
        System.out.println("Удалить упражнение");
    }

    @FXML
    private void btnUpdate() {
        System.out.println("Обновить таблицу");
    }
}