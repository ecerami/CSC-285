package edu.bhcc.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * User Create/Read/Delete Repo.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Find by Transaction ID.
     */
    User findByUserId(long userId);

    /**
     * Find by User Name.
     */
    User findByUserName(String userName);
}