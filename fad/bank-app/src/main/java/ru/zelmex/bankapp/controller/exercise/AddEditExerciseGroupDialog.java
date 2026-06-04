package ru.zelmex.bankapp.controller.exercise;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.zelmex.bankapp.model.ExerciseGroup;
import ru.zelmex.bankapp.service.ExerciseGroupService;

public class AddEditExerciseGroupDialog {

    @FXML private TextField titleField;
    @FXML private TextField typeOfLoadField;
    @FXML private TextField normsField;
    @FXML private Button okButton;
    @FXML private Label errorLabel;

    private Stage dialogStage;
    private ExerciseGroup exerciseGroup;

    public void setAddDialog(Stage stage) {
        this.dialogStage = stage;
        okButton.setOnAction(e -> add());
    }

    public void setEditDialog(Stage stage, ExerciseGroup group) {
        this.exerciseGroup = group;
        this.dialogStage = stage;
        titleField.setText(group.getTitle());
        typeOfLoadField.setText(group.getTypeOfLoad());
        normsField.setText(group.getNorms());
        okButton.setOnAction(e -> edit());
    }

    private void add() {
        try {
            ExerciseGroup newGroup = new ExerciseGroup();
            newGroup.setTitle(titleField.getText());
            newGroup.setTypeOfLoad(typeOfLoadField.getText());
            newGroup.setNorms(normsField.getText());
            new ExerciseGroupService().save(newGroup);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void edit() {
        try {
            exerciseGroup.setTitle(titleField.getText());
            exerciseGroup.setTypeOfLoad(typeOfLoadField.getText());
            exerciseGroup.setNorms(normsField.getText());
            new ExerciseGroupService().update(exerciseGroup);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }
}