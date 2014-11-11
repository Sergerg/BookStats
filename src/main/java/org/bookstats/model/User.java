package org.bookstats.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 11.11.2014
 * Time: 7:18
 */
public class User {
    private long id;
    private String login;
    private Timestamp created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    // Getters and setters
}