package org.bookstats.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 13.11.2014
 * Time: 11:44
 */
public class Link {

    private long id;
    private Timestamp created;

    private String title;
    private String url;
    private String note;
    private boolean ban;

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

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public boolean isBan() {
        return ban;
    }
    public void setBan(boolean ban) {
        this.ban = ban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;

        Link link = (Link) o;

        if (id != link.id) return false;
        if (!created.equals(link.created)) return false;
        if (!title.equals(link.title)) return false;

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
        return "Link{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", ban=" + ban +
                '}';
    }
}
