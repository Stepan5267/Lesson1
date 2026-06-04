package ru.zelmex.bankapp.controller.record;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.zelmex.bankapp.model.ExerciseGroup;
import ru.zelmex.bankapp.model.Record;
import ru.zelmex.bankapp.model.User;
import ru.zelmex.bankapp.service.ExerciseGroupService;
import ru.zelmex.bankapp.service.RecordService;
import ru.zelmex.bankapp.service.UserService;

import java.time.LocalDate;
import java.util.List;

public class AddEditRecordDialog {

    @FXML private ComboBox<User> userField;
    @FXML private ComboBox<ExerciseGroup> exerciseGroupField;
    @FXML private TextField caloriesField;
    @FXML private DatePicker dateField;
    @FXML private Button okButton;
    @FXML private Label errorLabel;

    private Stage dialogStage;
    private Record record;

    public void setAddDialog(Stage stage) {
        this.dialogStage = stage;
        loadComboBoxes();
        dateField.setValue(LocalDate.now());
        okButton.setOnAction(event -> add());
    }

    public void setEditDialog(Stage stage, Record record) {
        this.record = record;
        this.dialogStage = stage;
        loadComboBoxes();
        userField.setValue(record.getUser());
        exerciseGroupField.setValue(record.getExerciseGroup());
        caloriesField.setText(record.getCalories());
        dateField.setValue(record.getDate());
        okButton.setOnAction(event -> edit());
    }

    private void loadComboBoxes() {
        List<User> users = new UserService().findAll();
        userField.setItems(FXCollections.observableArrayList(users));
        if (!users.isEmpty()) userField.setValue(users.get(0));

        List<ExerciseGroup> groups = new ExerciseGroupService().findAll();
        exerciseGroupField.setItems(FXCollections.observableArrayList(groups));
        if (!groups.isEmpty()) exerciseGroupField.setValue(groups.get(0));
    }

    private void add() {
        try {
            Record newRecord = new Record();
            newRecord.setUser(userField.getValue());
            newRecord.setExerciseGroup(exerciseGroupField.getValue());
            newRecord.setCalories(caloriesField.getText());  // String, не int
            newRecord.setDate(dateField.getValue());        // LocalDate, не Date
            new RecordService().save(newRecord);
            dialogStage.close();
        } catch (Exception ex) {
            errorLabel.setText(ex.getMessage());
        }
    }

    private void edit() {
        try {
            record.setUser(userField.getValue());
            record.setExerciseGroup(exerciseGroupField.getValue());
            record.setCalories(caloriesField.getText());    // String, не int
            record.setDate(dateField.getValue());          // LocalDate, не Date
            new RecordService().update(record);
            dialogStage.close();
        } catch (Exception ex) {
            errorLabel.setText(ex.getMessage());
        }
    }
}