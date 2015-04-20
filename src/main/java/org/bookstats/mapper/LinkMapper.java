package org.bookstats.mapper;

import org.bookstats.model.Link;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 14.11.2014
 * Time: 9:30
 */
public interface LinkMapper {
    void addLink(Link link);
    List getAllLinks();
}
