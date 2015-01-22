package org.bookstats.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 22.01.2015
 * Time: 0:35
 */
public class Cycle {
    private long id;
    private Timestamp created;

    private String title; // Много?!
    private List<Book> books;
}
