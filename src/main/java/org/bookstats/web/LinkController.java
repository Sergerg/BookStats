package org.bookstats.web;

import org.bookstats.mapper.LinkMapper;
import org.bookstats.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 14.11.2014
 * Time: 9:39
 */
@RestController
public class LinkController {
    @Autowired
    private LinkMapper mapper;

    @RequestMapping(value = "/link/add")
    public List createUser(@RequestParam("title") String title, @RequestParam("url") String url) {
        Link link = new Link();
        link.setTitle(title);
        link.setUrl(url);
        mapper.addLink(link);

        return mapper.getAllLinks();
    }
}
