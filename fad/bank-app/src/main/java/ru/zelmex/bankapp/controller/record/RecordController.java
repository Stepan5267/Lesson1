package ru.zelmex.bankapp.controller.record;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.zelmex.bankapp.BankApp;
import ru.zelmex.bankapp.model.Record;
import ru.zelmex.bankapp.service.RecordService;

import java.io.IOException;
import java.util.List;

public class RecordController {

    private List<Record> records;
    private ObservableList<RecordTableItem> observableList;

    @FXML private TableView<RecordTableItem> recordsTable;
    @FXML private TableColumn<Record, String> userColumn;        // ФИО пользователя
    @FXML private TableColumn<Record, String> exerciseGroupColumn; // Группа упражнений
    @FXML private TableColumn<Record, String> caloriesColumn;
    @FXML private TableColumn<Record, String> dateColumn;

    @FXML void btnAdd(ActionEvent event) { openDialog(false, null); }

    @FXML void btnEdit(ActionEvent event) {
        RecordTableItem selected = recordsTable.getSelectionModel().getSelectedItem();
        if (selected != null) openDialog(true, selected.getRecord());
        else showWarning("Выберите запись для редактирования");
    }

    @FXML void btnDelete(ActionEvent event) {
        RecordTableItem selected = recordsTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Удалить запись?", ButtonType.OK, ButtonType.CANCEL);
            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                new RecordService().delete(selected.getRecord());
                observableList.remove(selected);
            }
        } else showWarning("Выберите запись для удаления");
    }

    @FXML void btnUpdate(ActionEvent event) { updateList(); }

    @FXML void switchToUsers(ActionEvent event) {
        BankApp.primaryStage.setScene(BankApp.users);
    }

    @FXML void switchToExerciseGroups(ActionEvent event) {
        BankApp.primaryStage.setScene(BankApp.exerciseGroups);
    }

    @FXML void exit(ActionEvent event) {
        BankApp.primaryStage.close();
    }

    private void openDialog(boolean isEdit, Record record) {
        try {
            FXMLLoader loader = new FXMLLoader(BankApp.class.getResource("add-edit-record-dialog.fxml"));
            Stage dialog = new Stage();
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(BankApp.primaryStage);
            dialog.setScene(new Scene(loader.load()));
            AddEditRecordDialog controller = loader.getController();
            if (isEdit) {
                dialog.setTitle("Редактировать запись");
                controller.setEditDialog(dialog, record);
            } else {
                dialog.setTitle("Добавить запись");
                controller.setAddDialog(dialog);
            }
            dialog.showAndWait();
            updateList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateList() {
        records = new RecordService().findAll();
        observableList.clear();
        for (Record r : records) {
            observableList.add(new RecordTableItem(r));
        }
        recordsTable.refresh();
    }

    private void showWarning(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        userColumn.setCellValueFactory(new PropertyValueFactory<>("userFio"));
        exerciseGroupColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseGroupTitle"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        observableList = FXCollections.observableArrayList();
        recordsTable.setItems(observableList);
        updateList();
    }
}