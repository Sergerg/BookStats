package org.bookstats.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 13.11.2014
 * Time: 11:42
 */
public class Tag {

    private long id;
    private Timestamp created;

    private String title;

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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        if (id != tag.id) return false;
        if (!created.equals(tag.created)) return false;
        if (!title.equals(tag.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + created.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
