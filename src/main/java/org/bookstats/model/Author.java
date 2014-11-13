package org.bookstats.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 13.11.2014
 * Time: 11:28
 */
public class Author {

    private long id;
    private Timestamp created;

    private String nick;
    private String family;
    private String name;
    private String fullname;
    private String engname;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEngname() {
        return engname;
    }
    public void setEngname(String engname) {
        this.engname = engname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (!nick.equals(author.nick)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + created.hashCode();
        result = 31 * result + nick.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                '}';
    }
}
