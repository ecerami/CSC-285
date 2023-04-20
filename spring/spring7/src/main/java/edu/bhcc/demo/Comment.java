package edu.bhcc.demo;

import jakarta.persistence.*;

/**
 * Comment Object.
 */
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private String comment;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    /**
     * Protected Constructor, used by JPA..
     */
    protected Comment() {
    }

    /**
     * Public Constructor, used to create new Objects.
     */
    public Comment(User user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

