package org.bookstats.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 13.11.2014
 * Time: 11:21
 */
public class Book {

    private long id;
    private Timestamp created;

    private String title; // Много?!
    private String engtitle;
    private List<Author> authors;
    private String description;
    private List<Genre> genres;
    private List<Tag> tags;
    //private List<Description>;
    //private List<Comments>;
    private String note;
    private List<Link> links;
    private Cycle cycle;

}
