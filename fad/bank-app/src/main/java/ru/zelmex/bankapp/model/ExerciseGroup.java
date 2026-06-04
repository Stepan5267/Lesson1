package ru.zelmex.bankapp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercise_groups")
public class ExerciseGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_groups_id")
    private Integer exerciseGroupsId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type_of_load")
    private String typeOfLoad;

    @Column(name = "norms")
    private String norms;

    @OneToMany(mappedBy = "exerciseGroup", cascade = CascadeType.ALL)
    private List<Record> records;

    // геттеры и сеттеры
    public Integer getExerciseGroupsId() { return exerciseGroupsId; }
    public void setExerciseGroupsId(Integer exerciseGroupsId) { this.exerciseGroupsId = exerciseGroupsId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getTypeOfLoad() { return typeOfLoad; }
    public void setTypeOfLoad(String typeOfLoad) { this.typeOfLoad = typeOfLoad; }
    public String getNorms() { return norms; }
    public void setNorms(String norms) { this.norms = norms; }
    public List<Record> getRecords() { return records; }
    public void setRecords(List<Record> records) { this.records = records; }
}