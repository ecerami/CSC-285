package edu.bhcc.todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Todo Create/Read/Delete Repo.
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {

    /**
     * Find by ID.
     */
    Todo findById(long id);


    /**
     * Find by Project.
     */
    List<Todo> findByProject(String project);
}