package ru.zelmex.bankapp.controller.user;

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
import ru.zelmex.bankapp.model.User;
import ru.zelmex.bankapp.service.UserService;

import java.io.IOException;
import java.util.List;

public class UserController {

    private List<User> users;
    private ObservableList<UserTableItem> userObservable;

    @FXML private TableView<UserTableItem> usersTable;
    @FXML private TableColumn<User, String> fioColumn;
    @FXML private TableColumn<?, ?> weightColumn;
    @FXML private TableColumn<?, ?> heightColumn;
    @FXML private TableColumn<?, ?> goalColumn;

    @FXML void btnAddUser(ActionEvent event) { openDialog(false, null); }
    @FXML void btnEditUser(ActionEvent event) {
        UserTableItem selected = usersTable.getSelectionModel().getSelectedItem();
        if (selected != null) openDialog(true, selected.getUser());
        else showWarning("Выберите запись для редактирования");
    }
    @FXML void btnDeleteUser(ActionEvent event) {
        UserTableItem selected = usersTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Удалить " + selected.getUser().getFio() + "?", ButtonType.OK, ButtonType.CANCEL);
            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                new UserService().delete(selected.getUser());
                userObservable.remove(selected);
            }
        } else showWarning("Выберите запись для удаления");
    }
    @FXML void btnRefresh(ActionEvent event) { updateList(); }

    @FXML void switchToExercises(ActionEvent event) { BankApp.primaryStage.setScene(BankApp.exerciseGroups); }
    @FXML void switchToRecords(ActionEvent event) { BankApp.primaryStage.setScene(BankApp.records); }
    @FXML void exit(ActionEvent event) { BankApp.primaryStage.close(); }

    private void openDialog(boolean isEdit, User user) {
        try {
            FXMLLoader loader = new FXMLLoader(BankApp.class.getResource("add-edit-user-dialog.fxml"));
            Stage dialog = new Stage();
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(BankApp.primaryStage);
            dialog.setScene(new Scene(loader.load()));
            AddEditUserDialog controller = loader.getController();
            if (isEdit) {
                dialog.setTitle("Редактировать пользователя");
                controller.setEditDialog(dialog, user);
            } else {
                dialog.setTitle("Добавить пользователя");
                controller.setAddDialog(dialog);
            }
            dialog.showAndWait();
            updateList();
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void updateList() {
        users = new UserService().findAll();
        userObservable.clear();
        for (User u : users) userObservable.add(new UserTableItem(u));
        usersTable.refresh();
    }

    private void showWarning(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg);
        alert.showAndWait();
    }

    @FXML public void initialize() {
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        goalColumn.setCellValueFactory(new PropertyValueFactory<>("goal"));
        userObservable = FXCollections.observableArrayList();
        usersTable.setItems(userObservable);
        updateList();
    }
}