package ru.zelmex.bankapp.model;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // первичный ключ (добавлен, если в таблице нет)

    @ManyToOne
    @JoinColumn(name = "exercise_groups", referencedColumnName = "title")
    private ExerciseGroup exerciseGroup;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "fio")
    private User user;

    @Column(name = "calories")
    private String calories;

    @Column(name = "date")
    private LocalDate date;

    // геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ExerciseGroup getExerciseGroup() { return exerciseGroup; }
    public void setExerciseGroup(ExerciseGroup exerciseGroup) { this.exerciseGroup = exerciseGroup; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getCalories() { return calories; }
    public void setCalories(String calories) { this.calories = calories; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}