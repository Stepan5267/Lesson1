package ru.zelmex.bankapp.controller.user;

import ru.zelmex.bankapp.model.User;
import javafx.beans.property.SimpleStringProperty;

public class UserTableItem {
    private SimpleStringProperty fio;
    private SimpleStringProperty weight;
    private SimpleStringProperty height;
    private SimpleStringProperty goal;
    private User user;

    public UserTableItem() {
    }

    public UserTableItem(User user) {
        this.fio = new SimpleStringProperty(user.getFio());
        this.weight = new SimpleStringProperty(user.getWeight());
        this.height = new SimpleStringProperty(user.getHeight());
        this.goal = new SimpleStringProperty(user.getGoal());
        this.user = user;
    }

    public String getFio() { return fio.get(); }
    public SimpleStringProperty fioProperty() { return fio; }
    public void setFio(String fio) { this.fio.set(fio); }

    public String getWeight() { return weight.get(); }
    public SimpleStringProperty weightProperty() { return weight; }
    public void setWeight(String weight) { this.weight.set(weight); }

    public String getHeight() { return height.get(); }
    public SimpleStringProperty heightProperty() { return height; }
    public void setHeight(String height) { this.height.set(height); }

    public String getGoal() { return goal.get(); }
    public SimpleStringProperty goalProperty() { return goal; }
    public void setGoal(String goal) { this.goal.set(goal); }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}