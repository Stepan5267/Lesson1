package ru.zelmex.bankapp.controller.user;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.zelmex.bankapp.model.User;
import ru.zelmex.bankapp.service.UserService;

public class AddEditUserDialog {

    @FXML private TextField fioField;
    @FXML private TextField weightField;
    @FXML private TextField heightField;
    @FXML private TextField goalField;
    @FXML private Button okButton;
    @FXML private Label errorLabel;

    private Stage dialogStage;
    private User user;

    public void setAddDialog(Stage stage) {
        this.dialogStage = stage;
        okButton.setOnAction(e -> add());
    }
    public void setEditDialog(Stage stage, User user) {
        this.user = user;
        this.dialogStage = stage;
        fioField.setText(user.getFio());
        weightField.setText(user.getWeight());
        heightField.setText(user.getHeight());
        goalField.setText(user.getGoal());
        okButton.setOnAction(e -> edit());
    }
    private void add() {
        try {
            User newUser = new User();
            newUser.setFio(fioField.getText());
            newUser.setWeight(weightField.getText());
            newUser.setHeight(heightField.getText());
            newUser.setGoal(goalField.getText());
            new UserService().save(newUser);
            dialogStage.close();
        } catch (IllegalArgumentException ex) { errorLabel.setText(ex.getMessage()); }
    }
    private void edit() {
        try {
            user.setFio(fioField.getText());
            user.setWeight(weightField.getText());
            user.setHeight(heightField.getText());
            user.setGoal(goalField.getText());
            new UserService().update(user);
            dialogStage.close();
        } catch (IllegalArgumentException ex) { errorLabel.setText(ex.getMessage()); }
    }
}