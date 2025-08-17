package simple.tasks.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.PENDING;

    private LocalDateTime createdAt;

    //Constructor
    public Tasks() {
        this.createdAt = LocalDateTime.now();
    }

    public Tasks(String title, String description, TaskStatus status, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Tasks(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum TaskStatus {
        PENDING,
        DONE,
    }
}
