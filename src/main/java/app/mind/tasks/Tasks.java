package app.mind.tasks;

import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
@Table
public class Tasks {
    @Id
    @SequenceGenerator(
        name = "task_sequence",
        sequenceName =  "task_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private LocalDate dateCreated;
    private LocalDate dateEdit;
    private String content;
    private String address;

    public Tasks(Long id, LocalDate dateCreated, LocalDate dateEdit, String content, String address) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateEdit = dateEdit;
        this.content = content;
        this.address = address;
    }

    public Tasks(LocalDate dateCreated, LocalDate dateEdit, String content, String address) {
        this.dateCreated = dateCreated;
        this.dateEdit = dateEdit;
        this.content = content;
        this.address = address;
    }

    public Tasks() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(LocalDate dateEdit) {
        this.dateEdit = dateEdit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateEdit=" + dateEdit +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
