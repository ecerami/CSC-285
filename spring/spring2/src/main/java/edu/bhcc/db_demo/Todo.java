package edu.bhcc.db_demo;

import jakarta.persistence.*;

/**
 * Customer Plain Old Java Object (POJO).
 */
@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private String project;
    private Boolean completed;

    /**
     * Protected Constructor, used by JPA..
     */
    protected Todo() {
    }

    /**
     * Public Constructor, used to create new Objects.
     */
    public Todo(String text, String project) {
        this.text = text;
        this.project = project;
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getProject() {
        return project;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%d, text='%s', project='%s', completed=%b]",
                id, text, project, completed);
    }
}

