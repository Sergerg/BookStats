package org.bookstats.mapper;

import org.bookstats.model.Author;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 13.11.2014
 * Time: 11:48
 */
public interface AuthorMapper {
    public void addAuthor(Author author);
    public List getAllAuthors();
}
