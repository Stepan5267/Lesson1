package ru.zelmex.bankapp.controller.record;

import ru.zelmex.bankapp.model.Record;
import javafx.beans.property.SimpleStringProperty;

public class RecordTableItem {
    private SimpleStringProperty userFio;
    private SimpleStringProperty exerciseGroupTitle;
    private SimpleStringProperty calories;
    private SimpleStringProperty date;
    private Record record;

    public RecordTableItem(Record record) {
        this.userFio = new SimpleStringProperty(record.getUser().getFio());
        this.exerciseGroupTitle = new SimpleStringProperty(record.getExerciseGroup().getTitle());
        this.calories = new SimpleStringProperty(record.getCalories());
        this.date = new SimpleStringProperty(record.getDate().toString());
        this.record = record;
    }

    public String getUserFio() { return userFio.get(); }
    public SimpleStringProperty userFioProperty() { return userFio; }
    public void setUserFio(String fio) { this.userFio.set(fio); }

    public String getExerciseGroupTitle() { return exerciseGroupTitle.get(); }
    public SimpleStringProperty exerciseGroupTitleProperty() { return exerciseGroupTitle; }
    public void setExerciseGroupTitle(String title) { this.exerciseGroupTitle.set(title); }

    public String getCalories() { return calories.get(); }
    public SimpleStringProperty caloriesProperty() { return calories; }
    public void setCalories(String calories) { this.calories.set(calories); }

    public String getDate() { return date.get(); }
    public SimpleStringProperty dateProperty() { return date; }
    public void setDate(String date) { this.date.set(date); }

    public Record getRecord() { return record; }
    public void setRecord(Record record) { this.record = record; }
}