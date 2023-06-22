package app.mind.tasks;

import jakarta.persistence.*;

//import lombok.Data;


@Entity
@Table(name = "tasks")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Tasks {
    @Id
    @Column(name = "id")
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
    @Column(name = "date_created")
    private String dateCreated;
    @Column(name = "date_Edit")
    private String dateEdit;
    @Column(name = "content")
    private String content;
    @Column(name = "address")
    private String address;

    public Tasks(Long id, String dateCreated, String dateEdit, String content, String address) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateEdit = dateEdit;
        this.content = content;
        this.address = address;
    }

    public Tasks(String dateCreated, String dateEdit, String content, String address) {
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(String dateEdit) {
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


