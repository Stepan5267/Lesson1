package ru.zelmex.bankapp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "weight")
    private String weight;

    @Column(name = "height")
    private String height;

    @Column(name = "goal")
    private String goal;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Record> records;

    // геттеры и сеттеры
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getFio() { return fio; }
    public void setFio(String fio) { this.fio = fio; }
    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }
    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }
    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }
    public List<Record> getRecords() { return records; }
    public void setRecords(List<Record> records) { this.records = records; }

    @Override
    public String toString() { return fio; }
}