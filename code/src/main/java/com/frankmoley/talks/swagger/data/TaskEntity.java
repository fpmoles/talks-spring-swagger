package com.frankmoley.talks.swagger.data;

import javax.persistence.*;

/**
 * @author Frank P. Moley III.
 */
@Entity
@Table(name="TASK")
public class TaskEntity {
    @Id
    @GeneratedValue
    @Column(name="TASK_ID")
    private long id;
    @Column(name="PERSON_ID")
    private long personId;
    @Column(name="TASK")
    private String task;
    @Column(name="COMPLETED")
    private boolean completed = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
