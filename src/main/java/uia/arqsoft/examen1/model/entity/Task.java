package uia.arqsoft.examen1.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Entity
@Table(name="tasks")
public class Task implements Serializable {
    private static final long serialVersioUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer status;

    @Column(name = "creation_date")
    private Date creationDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Task(){}
    public Task(String description, Integer status, Date creationDate) {
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
    }


}
