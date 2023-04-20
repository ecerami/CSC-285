package edu.bhcc.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Comment Create/Read/Delete Repo.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

    /**
     * Find by ID.
     */
    Comment findByCommentId(long commentId);


}