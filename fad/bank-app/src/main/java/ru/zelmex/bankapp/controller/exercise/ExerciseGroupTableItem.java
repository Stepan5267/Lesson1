package ru.zelmex.bankapp.controller.exercise;

import ru.zelmex.bankapp.model.ExerciseGroup;
import javafx.beans.property.SimpleStringProperty;

public class ExerciseGroupTableItem {
    private SimpleStringProperty title;
    private SimpleStringProperty typeOfLoad;
    private SimpleStringProperty norms;
    private ExerciseGroup exerciseGroup;

    public ExerciseGroupTableItem(ExerciseGroup exerciseGroup) {
        this.title = new SimpleStringProperty(exerciseGroup.getTitle());
        this.typeOfLoad = new SimpleStringProperty(exerciseGroup.getTypeOfLoad());
        this.norms = new SimpleStringProperty(exerciseGroup.getNorms());
        this.exerciseGroup = exerciseGroup;
    }

    public String getTitle() { return title.get(); }
    public SimpleStringProperty titleProperty() { return title; }
    public void setTitle(String title) { this.title.set(title); }

    public String getTypeOfLoad() { return typeOfLoad.get(); }
    public SimpleStringProperty typeOfLoadProperty() { return typeOfLoad; }
    public void setTypeOfLoad(String typeOfLoad) { this.typeOfLoad.set(typeOfLoad); }

    public String getNorms() { return norms.get(); }
    public SimpleStringProperty normsProperty() { return norms; }
    public void setNorms(String norms) { this.norms.set(norms); }

    public ExerciseGroup getExerciseGroup() { return exerciseGroup; }
    public void setExerciseGroup(ExerciseGroup exerciseGroup) { this.exerciseGroup = exerciseGroup; }
}