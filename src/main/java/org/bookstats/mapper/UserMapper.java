package org.bookstats.mapper;

import org.bookstats.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 11.11.2014
 * Time: 7:20
 */
public interface UserMapper {
    /**
     * Adds user to database.
     */
    void addUser(User user);

    /**
     * Gets all users from database.
     *
     * @return list of users, if no user exists returns empty list.
     */
    List getAllUsers();
}
